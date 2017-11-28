package com.tokid.service;
/*
* @Description: TODO 登录没写
* @author king
* @date 2017/11/19 11:05
*/

import com.tokid.base.exception.ServiceException;
import com.tokid.base.service.BaseService;
import com.tokid.base.utils.SequenceUtils;
import com.tokid.base.utils.UserLoginUtils;
import com.tokid.model.User;
import com.tokid.model.UserProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService extends BaseService<User, Long> {

    @Autowired
    private UserPropertyService userPropertyService;

    public Long saveOrUpdate(User user) throws ServiceException {
        Long id = null;
        if (user.getId() != null) {//编辑状态
            user.setPassword(user.getPassword() == null ? UserLoginUtils.DEFAUTE_PASSWORD : user.getPassword());
            //user.setUpdateBy(UserLoginUtils.getCurrentUserId());
            user.setUpdateTime(new Date());
            id = this.update(user);
        } else {
            //user.setCreateBy(UserLoginUtils.getCurrentUserId());
            user.setCreateTime(new Date());
            user.setState(1);
            user.setCode(SequenceUtils.getSecondUID("U"));
            id = this.insert(user);
        }
        return id;
    }

    public Long delete(Long[] ids) throws ServiceException {
        if (ids == null) {
            throw new ServiceException("ids is null");
        }
        this.deletes(ids);
        List<UserProperty> properties = new ArrayList<>();
        for (long id : ids) {
            UserProperty userProperty = new UserProperty();
            userProperty.setUserId(id);
            properties.add(userProperty);
        }
        //userPropertyService.deleteObjs();
        //userPropertyMapper.delete()
        //删除用户和角色对应关系
        return 1L;
    }

}
