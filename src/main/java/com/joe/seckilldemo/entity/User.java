package com.joe.seckilldemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author joe
 * @since 2024-06-25
 */
@Data
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID,手机号码
     */
    private Long id;

    private String nickname;

    /**
     * MD5(MD5(pass明文+固定salt)+salt)
     */
    private String password;

    private String salt;

    /**
     * 头像
     */
    private String head;

    /**
     * 注册时间
     */
    private Date registerDate;

    /**
     * 最后一次登录事件
     */
    private Date lastLoginDate;

    /**
     * 登录次数
     */
    private Integer loginCount;

    @Override
    public String toString() {
        return "User{" +
            "id = " + id +
            ", nickname = " + nickname +
            ", password = " + password +
            ", salt = " + salt +
            ", head = " + head +
            ", registerDate = " + registerDate +
            ", lastLoginDate = " + lastLoginDate +
            ", loginCount = " + loginCount +
        "}";
    }
}
