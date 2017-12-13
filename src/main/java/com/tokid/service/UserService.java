package com.tokid.service;
/*
* @Description: TODO 登录没写
* @author king
* @date 2017/11/19 11:05
*/

import com.tokid.base.customUtils.UserLoginUtils;
import com.tokid.base.exception.ServiceException;
import com.tokid.base.service.BaseService;
import com.tokid.base.utils.SequenceUtils;
import com.tokid.model.User;
import com.tokid.model.UserProperty;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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

    @Transactional
    public Object delete(Long userId) {
        int count = this.deleteByPrimaryKey(userId);//删除用户
        //删除用户角色关系
        UserProperty userProperty = new UserProperty();
        userProperty.setUserId(userId);
        userProperty = userPropertyService.selectOne(userProperty);
        if (userProperty.getId() != null) {
            count = userPropertyService.delete(userProperty);
        }
        return count;
    }

    /**
     * 退出登录
     * @return
     */
    public void logout() {
        Subject subject = SecurityUtils.getSubject(); // 获取Subject单例对象
        subject.logout(); // 退出
    }

    public void login() {
        

    }
}
