package com.tokid.mapper;
/*
* @Description: TODO
* @author king
* @date 2018/1/24 13:49
*/

import com.tokid.base.exception.ServiceException;
import com.tokid.base.mapper.BaseMapper;
import com.tokid.model.CClient;
import com.tokid.model.Permission;

import java.util.List;
import java.util.Map;

public interface CClientMapper extends BaseMapper<CClient> {

    List<Permission> getAllClient(Map<String, Object> map) throws ServiceException;
}
