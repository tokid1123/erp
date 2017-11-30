package com.tokid.base.model;
/*
* @Description:
* @author king
* @date 2017/11/24 15:13
*/

import com.tokid.model.User;

import java.util.Date;

public class LoginUser {

    //登陆人
    private User user ;

    //登录时间
    private Date loginTime;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
