package com.tokid.service;
/*
* @Description: TODO
* @author king
* @date 2017/11/24 11:36
*/

import com.tokid.base.service.BaseService;
import com.tokid.mapper.UserPropertyMapper;
import com.tokid.model.UserProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPropertyService extends BaseService<UserProperty, Long>{

    @Autowired
    private UserPropertyMapper userPropertyMapper;
}
