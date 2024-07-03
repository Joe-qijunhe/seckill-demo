package com.joe.seckilldemo.listener;

import com.joe.seckilldemo.service.IOrderService;
import com.joe.seckilldemo.vo.SeckillMessage;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeckillSuccessListener {

    @Autowired
    private IOrderService orderService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "seckill.queue", durable = "true"),
            exchange = @Exchange(name = "seckill.topic", type = ExchangeTypes.TOPIC),
            key = "seckill.success"
    ))
    public void listenSeckillSuccess(SeckillMessage message) {
        Long userId = message.getUserId();
        Long goodsId = message.getGoodsId();
        // 减库存，并生成订单
        orderService.createSeckillOrder(userId, goodsId);
    }
}
