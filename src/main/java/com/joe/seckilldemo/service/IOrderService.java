package com.joe.seckilldemo.service;

import com.joe.seckilldemo.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.joe.seckilldemo.entity.User;
import com.joe.seckilldemo.vo.GoodsVo;
import com.joe.seckilldemo.vo.RespBean;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author joe
 * @since 2024-06-25
 */
public interface IOrderService extends IService<Order> {

    Order secKill(User user, Long goodsId);
    RespBean doSekill(User user, Long goodsId);
}
