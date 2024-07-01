package com.joe.seckilldemo.service;

import com.joe.seckilldemo.entity.SeckillGoods;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 秒杀商品表 服务类
 * </p>
 *
 * @author joe
 * @since 2024-06-25
 */
public interface ISeckillGoodsService extends IService<SeckillGoods> {
    public void loadAllSeckillGoods();
}
