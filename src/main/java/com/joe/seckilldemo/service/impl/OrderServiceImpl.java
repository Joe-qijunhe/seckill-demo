package com.joe.seckilldemo.service.impl;

import com.joe.seckilldemo.entity.Order;
import com.joe.seckilldemo.mapper.OrderMapper;
import com.joe.seckilldemo.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

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

}
