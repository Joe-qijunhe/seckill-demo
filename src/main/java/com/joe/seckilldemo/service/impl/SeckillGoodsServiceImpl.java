package com.joe.seckilldemo.service.impl;

import com.joe.seckilldemo.entity.Order;
import com.joe.seckilldemo.entity.SeckillGoods;
import com.joe.seckilldemo.entity.User;
import com.joe.seckilldemo.mapper.SeckillGoodsMapper;
import com.joe.seckilldemo.service.ISeckillGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 秒杀商品表 服务实现类
 * </p>
 *
 * @author joe
 * @since 2024-06-25
 */
@Service
@Primary
public class SeckillGoodsServiceImpl extends ServiceImpl<SeckillGoodsMapper, SeckillGoods> implements ISeckillGoodsService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private SeckillGoodsMapper seckillGoodsMapper;

    @Override
    public void loadAllSeckillGoods() {
        List<SeckillGoods> seckillGoods = seckillGoodsMapper.selectList(null);
        seckillGoods.forEach(seckillGoods1 -> redisTemplate.opsForValue().set("seckill:stock:" + seckillGoods1.getGoodsId(), seckillGoods1.getStockCount()));
    }
}
