package com.tokid.controller;
/*
* @Description: TODO
* @author king
* @date 2017/11/20 15:59
*/

import com.tokid.model.User;
import com.tokid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/testUserMapper")
    public Object testUserMapper(){
        User user = new User();
        user.setUsername("king");
        user.setPassword("123456");
        return user;
    }

}
