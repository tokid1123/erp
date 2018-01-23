package com.tokid.controller;
/*
* @Description:
* @author king
* @date 2017/12/13 11:13
*/

import com.tokid.base.cache.CacheManager;
import com.tokid.base.customUtils.Result;
import com.tokid.base.customUtils.ResultEnum;
import com.tokid.base.customUtils.UserLoginUtils;
import com.tokid.model.User;
import com.tokid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     */
    @RequestMapping("/login")
    public Object login(@RequestBody User user) {
        try {
            return userService.login(user);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.createErrorResultForm(null);
        }
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "/logout")
    public Object logout() {
        try {
            userService.logout();
            return Result.createSuccessResultForm(ResultEnum.LOGOUTSECCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.createErrorResultForm(null);
        }
    }

    //检查session是否有效
    @RequestMapping(value = "checkSession", method = RequestMethod.GET)
    public Object checkSession() {
        try {
            CacheManager cacheManager = CacheManager.getInstance();
            String username = UserLoginUtils.getCurrentUser().getUser().getUsername();
            String sessionId = String.valueOf(cacheManager.get(username));
            return Result.createSuccessResultForm(sessionId, ResultEnum.CHECKSESSIONSUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.createErrorResultForm(null);
        }
    }

}
