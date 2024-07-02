package com.joe.seckilldemo.controller;

import com.joe.seckilldemo.entity.User;
import com.joe.seckilldemo.service.IOrderService;
import com.joe.seckilldemo.service.ISeckillGoodsService;
import com.joe.seckilldemo.service.ISeckillOrderService;
import com.joe.seckilldemo.vo.RespBean;
import com.joe.seckilldemo.vo.RespBeanEnum;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/seckill")
public class SecKillController implements InitializingBean {

    @Autowired
    private IOrderService orderService;
    @Autowired
    private ISeckillGoodsService seckillGoodsService;
    @Autowired
    private ISeckillOrderService seckillOrderService;

    @PostMapping("/doSeckill/{goodsId}")
    @ResponseBody
    public RespBean doSecKill(User user, @PathVariable(value = "goodsId") Long goodsId) {
        if (user == null) {
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        System.out.println(goodsId);
        return orderService.doSekill(user.getId(), goodsId);
    }

    @GetMapping("/result/{goodsId}")
    @ResponseBody
    public RespBean result(User user, @PathVariable(value = "goodsId") Long goodsId) {
        if (user == null) {
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        Long orderId = seckillOrderService.getOrder(user.getId(), goodsId);
        return RespBean.success(orderId);
    }

    /**
     * 系统初始化，把秒杀商品库存数量加载到Redis中去
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        seckillGoodsService.loadAllSeckillGoods();
    }
}
