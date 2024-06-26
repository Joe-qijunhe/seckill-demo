package com.joe.seckilldemo.controller;

import com.joe.seckilldemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author joe
 * @since 2024-06-25
 */
@Controller
@RequestMapping("/seckilldemo/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/all")
    public void getAll() {
        System.out.println(userService.getById(1000));
    }
}
