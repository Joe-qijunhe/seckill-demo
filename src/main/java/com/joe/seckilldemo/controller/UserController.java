package com.joe.seckilldemo.controller;

import com.joe.seckilldemo.service.IUserService;
import com.joe.seckilldemo.vo.PasswordVo;
import com.joe.seckilldemo.vo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author joe
 * @since 2024-06-25
 */
@Controller
@RequestMapping("/seckill/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/update")
    @ResponseBody
    public RespBean getAll(@RequestBody PasswordVo passwordVo) {
        return userService.updatePassword(passwordVo.getUserTicket(), passwordVo.getOldPassword(), passwordVo.getNewPassword());
    }
}
