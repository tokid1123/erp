package com.tokid.service;
/*
* @Description:
* @author king
* @date 2017/11/24 11:36
*/

import com.tokid.base.exception.ServiceException;
import com.tokid.base.service.BaseService;
import com.tokid.model.UserProperty;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserPropertyService extends BaseService<UserProperty, Long> {

    public Long saveOrUpdate(UserProperty userProperty) throws ServiceException {
        Long id = null;
        UserProperty temp = new UserProperty();
        temp.setUserId(userProperty.getUserId());
        temp = this.selectOne(temp);
        if (temp == null || temp.getId() == null) {
            userProperty.setCreateTime(new Date());
            //userProperty.setCreateBy(UserLoginUtils.getCurrentUserId());
            id = this.insert(userProperty);
        } else if (temp.getId() != null) {
            //userProperty.setUpdateBy(UserLoginUtils.getCurrentUserId());
            temp.setUpdateTime(new Date());
            temp.setPropertyId(userProperty.getPropertyId());
            id = this.update(temp);
        }
        return id;
    }

}
