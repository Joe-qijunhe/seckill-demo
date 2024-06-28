package com.joe.seckilldemo.service;

import com.joe.seckilldemo.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.joe.seckilldemo.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author joe
 * @since 2024-06-25
 */
public interface IGoodsService extends IService<Goods> {
    public List<GoodsVo> findGoodsVo();

    public GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
