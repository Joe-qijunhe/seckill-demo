package com.joe.seckilldemo.controller;

import com.joe.seckilldemo.entity.User;
import com.joe.seckilldemo.service.IGoodsService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.thymeleaf.util.StringUtils;

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

    @RequestMapping("/toList")
    public String test(HttpSession session, Model model, @CookieValue("userTicket") String userTicket) {
        if (StringUtils.isEmpty(userTicket)) {
            return "login";
        }
        User user = (User) session.getAttribute(userTicket);
        if (user == null) {
            return "login";
        }
        model.addAttribute("user", user);
        return "goodsList";
    }
}
