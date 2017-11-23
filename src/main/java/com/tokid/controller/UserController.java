package com.tokid.controller;
/*
* @Description: TODO
* @author king
* @date 2017/11/20 15:59
*/

import com.tokid.base.utils.Result;
import com.tokid.base.utils.ResultEnum;
import com.tokid.base.utils.StringUtils;
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

    @RequestMapping("/save")
    public Object save(Object o) {
        Result<?> result = null;
//        User user = body.tryGet(User.class);
        User user = new User();
        user.setName("name");
        user.setUsername("username");
        user.setPassword("password");
        try {
            //业务验证放在service
            if (StringUtils.isBlank(user.getName())) {
                throw new Exception("name is null");
            }
            if (StringUtils.isBlank(user.getUsername())) {
                throw new Exception("username is null");
            }
            if (StringUtils.isBlank(user.getPassword())) {
                throw new Exception("password is null");
            }
            result = Result.createSuccessResultForm(userService.insert(user), ResultEnum.success);
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(null, ResultEnum.error);
        }
        return result;
    }

}
