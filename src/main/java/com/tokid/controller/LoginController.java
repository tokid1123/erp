package com.tokid.controller;
/*
* @Description: TODO 登录没写
* @author king
* @date 2017/12/13 11:13
*/

import com.tokid.base.customUtils.Result;
import com.tokid.base.customUtils.ResultEnum;
import com.tokid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     */
    @RequestMapping("/login")
    public Object login() {
        try {
            userService.login();
            return Result.createSuccessResultForm(ResultEnum.success);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.createErrorResultForm(ResultEnum.error);
        }
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "/logout")
    public Object logout() {
        try {
            userService.logout();
            return Result.createSuccessResultForm(ResultEnum.success);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.createErrorResultForm(ResultEnum.error);
        }
    }

}
