package com.joe.seckilldemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 秒杀商品表
 * </p>
 *
 * @author joe
 * @since 2024-06-25
 */
@Data
@TableName("t_seckill_goods")
public class SeckillGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 秒杀商品ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 秒杀价
     */
    private BigDecimal seckillPrice;

    /**
     * 库存数量
     */
    private Integer stockCount;

    /**
     * 秒杀开始时间
     */
    private Date startDate;

    /**
     * 秒杀结束时间
     */
    private Date endDate;

    @Override
    public String toString() {
        return "SeckillGoods{" +
            "id = " + id +
            ", goodsId = " + goodsId +
            ", seckillPrice = " + seckillPrice +
            ", stockCount = " + stockCount +
            ", startDate = " + startDate +
            ", endDate = " + endDate +
        "}";
    }
}
