package com.joe.seckilldemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.joe.seckilldemo.entity.Order;
import com.joe.seckilldemo.entity.SeckillOrder;
import com.joe.seckilldemo.entity.User;
import com.joe.seckilldemo.service.IGoodsService;
import com.joe.seckilldemo.service.IOrderService;
import com.joe.seckilldemo.service.ISeckillOrderService;
import com.joe.seckilldemo.vo.GoodsVo;
import com.joe.seckilldemo.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seckill")
public class SecKillController {

    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private ISeckillOrderService seckillOrderService;
    @Autowired
    private IOrderService orderService;

    @RequestMapping("/doSeckill")
    public String doSecKill(Model model, User user, Long goodsId) {
        if (user == null) {
            return "login";
        }
        model.addAttribute("user", user);
        Order order = orderService.secKill(user, goodsId);
        model.addAttribute("order", order);
        model.addAttribute("goods", goodsService.findGoodsVoByGoodsId(goodsId));
        return "orderDetail";
    }
}
