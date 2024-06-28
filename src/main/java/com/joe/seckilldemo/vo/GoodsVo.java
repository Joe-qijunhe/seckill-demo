package com.joe.seckilldemo.vo;

import com.joe.seckilldemo.entity.Goods;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class GoodsVo extends Goods {
    /**
     * 秒杀价格
     **/
    private BigDecimal seckillPrice;

    /**
     * 剩余数量
     **/
    private Integer stockCount;

    /**
     * 开始时间
     **/
    private Date startDate;

    /**
     * 结束时间
     **/
    private Date endDate;
}
