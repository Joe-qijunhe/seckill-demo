package com.joe.seckilldemo.service.impl;

import com.joe.seckilldemo.entity.Goods;
import com.joe.seckilldemo.mapper.GoodsMapper;
import com.joe.seckilldemo.service.IGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author joe
 * @since 2024-06-25
 */
@Service
@Primary
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

}
