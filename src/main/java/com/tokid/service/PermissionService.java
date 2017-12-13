package com.tokid.service;
/*
* @Description:
* @author king
* @date 2017/11/24 14:43
*/

import com.tokid.base.exception.ServiceException;
import com.tokid.base.service.BaseService;
import com.tokid.mapper.PermissionMapper;
import com.tokid.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PermissionService extends BaseService<Permission, Long>{

    @Autowired
    private PermissionMapper permissionMapper;

    public Long saveOrUpdate(Permission permission) throws ServiceException {
        Long id ;
            if (permission.getId() != null) {//编辑状态
                //permission.setUpdateBy(UserLoginUtils.getCurrentUserId());
                permission.setUpdateTime(new Date());
                id = this.update(permission);
            } else {
                //permission.setCreateBy(UserLoginUtils.getCurrentUserId());
                permission.setCreateTime(new Date());
                permission.setState(1);
                id = this.insert(permission);
            }
        return id;
    }

    public List<Permission> getAllPermissions(Map<String, Object> map) throws ServiceException {
        return permissionMapper.getAllPermissions(map);
    }
}
