package com.tokid.controller;/*
* @Description: TODO
* @author king
* @date 2018/9/11  19:59
*/

import com.tokid.base.customUtils.Result;
import com.tokid.base.customUtils.ResultEnum;
import com.tokid.model.KUser;
import com.tokid.service.KUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kUser")
public class KUserController {

    @Autowired
    private KUserService service;

    @RequestMapping("/getUser")
    public Object getUser(){
        KUser user = new KUser();
        user.setId("1");
        return   Result.createSuccessResultForm(service.selectOne(user), ResultEnum.SUCCESS);
    }

}
