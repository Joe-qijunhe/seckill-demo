package com.joe.seckilldemo.service.impl;

import com.joe.seckilldemo.entity.SeckillOrder;
import com.joe.seckilldemo.mapper.SeckillOrderMapper;
import com.joe.seckilldemo.service.ISeckillOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 秒杀订单表 服务实现类
 * </p>
 *
 * @author joe
 * @since 2024-06-25
 */
@Service
@Primary
public class SeckillOrderServiceImpl extends ServiceImpl<SeckillOrderMapper, SeckillOrder> implements ISeckillOrderService {

}
