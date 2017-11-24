package com.tokid.service;
/*
* @Description: TODO
* @author king
* @date 2017/11/24 14:44
*/

import com.tokid.base.service.BaseService;
import com.tokid.mapper.PropertyPermissionMapper;
import com.tokid.model.PropertyPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyPermissionService extends BaseService<PropertyPermission, Long>{

    @Autowired
    private PropertyPermissionMapper propertyPermissionMapper;
}
