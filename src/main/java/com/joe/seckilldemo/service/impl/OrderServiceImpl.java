package com.joe.seckilldemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joe.seckilldemo.entity.*;
import com.joe.seckilldemo.mapper.GoodsMapper;
import com.joe.seckilldemo.mapper.OrderMapper;
import com.joe.seckilldemo.service.IGoodsService;
import com.joe.seckilldemo.service.IOrderService;
import com.joe.seckilldemo.service.ISeckillGoodsService;
import com.joe.seckilldemo.service.ISeckillOrderService;
import com.joe.seckilldemo.vo.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author joe
 * @since 2024-06-25
 */
@Service
@Primary
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    private ISeckillGoodsService seckillGoodsService;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ISeckillOrderService seckillOrderService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private IGoodsService goodsService;

    private static final DefaultRedisScript<Long> SECKILL_SCRIPT;

    static {
        SECKILL_SCRIPT = new DefaultRedisScript<>();
        SECKILL_SCRIPT.setLocation(new ClassPathResource("seckill.lua"));
        SECKILL_SCRIPT.setResultType(Long.class);
    }

    @Override
    public Order createSeckillOrder(Long userId, Long goodsId) {
        //秒杀商品表减库存
        boolean seckillGoodsResult = seckillGoodsService.update(new UpdateWrapper<SeckillGoods>().setSql("stock_count = " + "stock_count-1")
                .eq("goods_id", goodsId)
                .gt("stock_count", 0));
        if (!seckillGoodsResult) {
            return null;
        }
        Goods goods = goodsMapper.selectById(goodsId);
        //生成订单
        Order order = new Order();
        order.setUserId(userId);
        order.setGoodsId(goodsId);
        order.setDeliveryAddrId(0L);
        order.setGoodsName(goods.getGoodsName());
        order.setGoodsCount(1);
        order.setOrderChannel(1);
        order.setStatus(0);
        order.setCreateDate(new Date());
        orderMapper.insert(order);
        //生成秒杀订单
        SeckillOrder tSeckillOrder = new SeckillOrder();
        tSeckillOrder.setUserId(userId);
        tSeckillOrder.setOrderId(order.getId());
        tSeckillOrder.setGoodsId(goodsId);
        seckillOrderService.save(tSeckillOrder);
        return order;
    }

    @Override
    public RespBean doSekill(Long userId, Long goodsId) {
        //1. 执行lua脚本
        Long result = stringRedisTemplate.execute(SECKILL_SCRIPT, Collections.emptyList(), goodsId.toString(), userId.toString());
        //2. 判断返回值，并返回错误信息
        if (result.intValue() != 0) {
            return result.intValue() == 1 ? RespBean.error(RespBeanEnum.EMPTY_STOCK) : RespBean.error(RespBeanEnum.REPEATE_ERROR);
        }
        //3. 发送消息到消息队列
        SeckillMessage message = new SeckillMessage(userId, goodsId);
        rabbitTemplate.convertAndSend("seckill.topic", "seckill.success", message);
        return RespBean.success();
    }

    @Override
    public OrderDeatilVo detail(Long orderId) {
        Order tOrder = orderMapper.selectById(orderId);
        GoodsVo goodsVobyGoodsId = goodsService.findGoodsVoByGoodsId(tOrder.getGoodsId());
        OrderDeatilVo orderDeatilVo = new OrderDeatilVo();
        orderDeatilVo.setOrder(tOrder);
        orderDeatilVo.setGoodsVo(goodsVobyGoodsId);
        return orderDeatilVo;
    }
}
