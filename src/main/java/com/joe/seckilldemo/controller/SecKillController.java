package com.joe.seckilldemo.controller;

import com.joe.seckilldemo.entity.User;
import com.joe.seckilldemo.service.IOrderService;
import com.joe.seckilldemo.service.ISeckillGoodsService;
import com.joe.seckilldemo.vo.RespBean;
import com.joe.seckilldemo.vo.RespBeanEnum;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/seckill")
public class SecKillController implements InitializingBean {

    @Autowired
    private IOrderService orderService;
    @Autowired
    private ISeckillGoodsService seckillGoodsService;

    @RequestMapping("/doSeckill")
    @ResponseBody
    public RespBean doSecKill(User user, Long goodsId) {
        if (user == null) {
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        return orderService.doSekill(user, goodsId);
    }

    /**
     * 系统初始化，把秒杀商品库存数量加载到Redis中去
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        seckillGoodsService.loadAllSeckillGoods();
    }
}
