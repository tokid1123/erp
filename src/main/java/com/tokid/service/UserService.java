package com.tokid.service;
/*
* @Description: TODO
* @author king
* @date 2017/11/19 11:05
*/

import com.tokid.base.service.BaseService;
import com.tokid.mapper.UserMapper;
import com.tokid.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, Long>{

    @Autowired
    protected UserMapper mapper;

}
