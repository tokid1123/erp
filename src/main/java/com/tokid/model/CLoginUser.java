package com.tokid.model;/*
* @Description: TODO
* @author king
* @date 2018/4/11  22:35
*/

import java.io.Serializable;

public class CLoginUser {

    private CUser user;

    private String token;

    public CUser getUser() {
        return user;
    }

    public void setUser(CUser user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
