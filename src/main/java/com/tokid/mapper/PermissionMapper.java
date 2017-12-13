package com.tokid.mapper;
/*
* @Description:
* @author king
* @date 2017/11/23 9:04
*/

import com.tokid.base.exception.ServiceException;
import com.tokid.base.mapper.BaseMapper;
import com.tokid.model.Permission;

import java.util.List;
import java.util.Map;

public interface PermissionMapper extends BaseMapper<Permission>{

    List<Permission> getAllPermissions(Map<String, Object> map) throws ServiceException;
}
