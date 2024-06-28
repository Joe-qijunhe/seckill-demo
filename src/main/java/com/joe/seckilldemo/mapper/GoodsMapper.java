package com.joe.seckilldemo.mapper;

import com.joe.seckilldemo.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.joe.seckilldemo.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author joe
 * @since 2024-06-25
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    List<GoodsVo> findGoodsVo();

    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
