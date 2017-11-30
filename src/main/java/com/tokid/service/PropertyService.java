package com.tokid.service;
/*
* @Description:
* @author king
* @date 2017/11/24 14:42
*/

import com.tokid.base.exception.ServiceException;
import com.tokid.base.service.BaseService;
import com.tokid.model.Property;
import com.tokid.model.PropertyPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PropertyService extends BaseService<Property, Long> {

    @Autowired
    private PropertyPermissionService propertyPermissionService;

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

    public Object deleteById(Long propertyId) throws ServiceException {
        int count = 0;
        this.deleteByPrimaryKey(propertyId);//删除角色
        //删除角色权限对应关系
        PropertyPermission propertyPermission = new PropertyPermission();
        propertyPermission.setPropertyId(propertyId);
        List<PropertyPermission> selectList = propertyPermissionService.select(propertyPermission);
        if (selectList != null && selectList.size() > 0) {
            count = propertyPermissionService.deleteList(selectList);
        }
        return count;
    }
}
