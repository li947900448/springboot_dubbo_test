package com.lsf.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/2/21.
 */
@Data
public class User implements Serializable {
    private Integer userId;

    private String userName;

    private String password;

    private String phone;

  /*  public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }*/
}
