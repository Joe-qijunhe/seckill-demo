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
 * 订单表
 * </p>
 *
 * @author joe
 * @since 2024-06-25
 */
@Data
@TableName("t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 收获地址ID
     */
    private Long deliveryAddrId;

    /**
     * 商品名字
     */
    private String goodsName;

    /**
     * 商品数量
     */
    private Integer goodsCount;

    /**
     * 商品价格
     */
    private BigDecimal goodsPrice;

    /**
     * 1 pc,2 android, 3 ios
     */
    private Integer orderChannel;

    /**
     * 订单状态，0新建未支付，1已支付，2已发货，3已收货，4已退货，5已完成
     */
    private Integer status;

    /**
     * 订单创建时间
     */
    private Date createDate;

    /**
     * 支付时间
     */
    private Date payDate;

    @Override
    public String toString() {
        return "Order{" +
            "id = " + id +
            ", userId = " + userId +
            ", goodsId = " + goodsId +
            ", deliveryAddrId = " + deliveryAddrId +
            ", goodsName = " + goodsName +
            ", goodsCount = " + goodsCount +
            ", goodsPrice = " + goodsPrice +
            ", orderChannel = " + orderChannel +
            ", status = " + status +
            ", createDate = " + createDate +
            ", payDate = " + payDate +
        "}";
    }
}
