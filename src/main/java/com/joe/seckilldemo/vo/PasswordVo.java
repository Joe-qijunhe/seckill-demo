package com.joe.seckilldemo.vo;

import lombok.Data;

@Data
public class PasswordVo {
    private String userTicket;
    private String oldPassword;
    private String newPassword;
}
