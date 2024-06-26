package com.joe.seckilldemo.service.impl;

import com.joe.seckilldemo.entity.User;
import com.joe.seckilldemo.mapper.UserMapper;
import com.joe.seckilldemo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joe.seckilldemo.utils.CookieUtil;
import com.joe.seckilldemo.utils.MD5Util;
import com.joe.seckilldemo.utils.UUIDUtil;
import com.joe.seckilldemo.vo.LoginVo;
import com.joe.seckilldemo.vo.RespBean;
import com.joe.seckilldemo.vo.RespBeanEnum;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author joe
 * @since 2024-06-25
 */
@Service
@Primary
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        // 省略一些参数校验
        User user = userMapper.selectById(mobile);
        if (user == null) {
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        log.info(MD5Util.formPassToDBPass(password, user.getSalt()));
        if (!MD5Util.formPassToDBPass(password, user.getSalt()).equals(user.getPassword())) {
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        //生成Cookie
        String userTicket = UUIDUtil.uuid();
        request.getSession().setAttribute(userTicket, user);
        CookieUtil.setCookie(request, response, "userTicket", userTicket);
        return RespBean.success();
    }
}
