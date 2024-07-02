package com.joe.seckilldemo.controller;

import com.joe.seckilldemo.entity.User;
import com.joe.seckilldemo.service.IOrderService;
import com.joe.seckilldemo.vo.OrderDeatilVo;
import com.joe.seckilldemo.vo.RespBean;
import com.joe.seckilldemo.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @RequestMapping(value = "/detail")
    @ResponseBody
    public RespBean detail(User tUser, Long orderId) {
        if (tUser == null) {
            return RespBean.error(RespBeanEnum.SESSION_ERROR);
        }
        OrderDeatilVo orderDeatilVo = orderService.detail(orderId);
        return RespBean.success(orderDeatilVo);
    }
}
