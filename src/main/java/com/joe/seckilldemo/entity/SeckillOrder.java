package com.joe.seckilldemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 秒杀订单表
 * </p>
 *
 * @author joe
 * @since 2024-06-25
 */
@Data
@TableName("t_seckill_order")
public class SeckillOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 秒杀订单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 订单ID
     */
    private Long orderId;

    /**
     * 商品ID
     */
    private Long goodsId;

    @Override
    public String toString() {
        return "SeckillOrder{" +
            "id = " + id +
            ", userId = " + userId +
            ", orderId = " + orderId +
            ", goodsId = " + goodsId +
        "}";
    }
}
