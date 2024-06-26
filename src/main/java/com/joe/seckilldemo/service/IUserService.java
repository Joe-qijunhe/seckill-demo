package com.joe.seckilldemo.service;

import com.joe.seckilldemo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.joe.seckilldemo.vo.LoginVo;
import com.joe.seckilldemo.vo.RespBean;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author joe
 * @since 2024-06-25
 */
public interface IUserService extends IService<User> {
    public RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);
}
