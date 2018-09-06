package com.tokid.testUser;


import com.tokid.base.customUtils.JsonRequestBody;
import com.tokid.base.customUtils.Result;
import com.tokid.model.CUser;
import com.tokid.service.CUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private KUserService service;

    /**
     * 登录
     */
    @RequestMapping("/login")
    public Object login(@RequestBody JsonRequestBody body) {
        try {
            KUser user = body.tryGet(KUser.class);
            return service.login(user);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.createErrorResultForm(null);
        }
    }
}
