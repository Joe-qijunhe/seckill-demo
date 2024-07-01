package com.joe.seckilldemo.service.impl;

import com.joe.seckilldemo.entity.Order;
import com.joe.seckilldemo.entity.SeckillGoods;
import com.joe.seckilldemo.entity.User;
import com.joe.seckilldemo.mapper.SeckillGoodsMapper;
import com.joe.seckilldemo.service.ISeckillGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

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

}
