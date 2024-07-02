package com.joe.seckilldemo.vo;

import com.joe.seckilldemo.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单详情返回对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDeatilVo {
    private Order order;
    private GoodsVo goodsVo;
}
