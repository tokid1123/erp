package com.tokid.service;
/*
* @Description: TODO
* @author king
* @date 2017/11/24 14:42
*/

import com.tokid.base.exception.ServiceException;
import com.tokid.base.service.BaseService;
import com.tokid.base.utils.UserLoginUtils;
import com.tokid.mapper.PropertyMapper;
import com.tokid.model.Property;
import com.tokid.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PropertyService extends BaseService<Property, Long>{

    @Autowired
    private PropertyMapper propertyMapper;

    public Long saveOrUpdate(Property property) throws ServiceException {
        Long id = null;
        if (property.getId() != null) {//编辑状态
            //property.setUpdateBy(UserLoginUtils.getCurrentUserId());
            property.setUpdateTime(new Date());
            id = this.update(property);
        } else {
            //property.setCreateBy(UserLoginUtils.getCurrentUserId());
            property.setCreateTime(new Date());
            property.setState(1);
            id = this.insert(property);
        }
        return id;
    }
}
