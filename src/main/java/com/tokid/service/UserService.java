package com.tokid.service;
/*
* @Description: TODO
* @author king
* @date 2017/11/19 11:05
*/

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.tokid.base.service.BaseService;
import com.tokid.mapper.UserMapper;
import com.tokid.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.logging.Logger;

@Service
public class UserService extends BaseService<User, Long> {

    @Autowired
    protected UserMapper mapper;

    public Long save(User user) {
        Long id = null;
        try {
            if (user == null) {
                throw new Exception("user is null");
            }
            if (user.getId() != null) {//编辑状态
                user.setPassword(user.getPassword() == null ? "123456" : user.getPassword());
                user.setUpdateBy(user.getId());//当前用户的id
                user.setUpdateTime(new Date());
                id = this.update(user);
            } else {
                user.setCreateBy(user.getId());//当前用户的id
                user.setCreateTime(new Date());
                id = this.insert(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            //自定义异常
        }
        return id;
    }

}
