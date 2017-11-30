package com.tokid.model;
/*
* @Description:
* @author king
* @date 2017/11/15 15:02
*/

import com.tokid.base.model.BaseModel;

import javax.persistence.Table;

@Table(name="user")
public class User extends BaseModel{

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private String mobile;

    private String email;

    private String image;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
