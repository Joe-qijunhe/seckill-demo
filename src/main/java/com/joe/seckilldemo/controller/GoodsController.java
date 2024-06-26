package com.joe.seckilldemo.controller;

import com.joe.seckilldemo.entity.User;
import com.joe.seckilldemo.service.IGoodsService;
import com.joe.seckilldemo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author joe
 * @since 2024-06-25
 */
@Controller
@RequestMapping("/goods")
@Slf4j
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private IUserService userService;

    @RequestMapping("/toList")
    public String toList(Model model, User user) {
        if (user == null) {
            return "login";
        }
        model.addAttribute("user", user);
        return "goodsList";
    }
}
