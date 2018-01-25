package com.tokid.mapper;
/*
* @Description: TODO
* @author king
* @date 2018/1/24 16:36
*/

import com.tokid.base.exception.ServiceException;
import com.tokid.base.mapper.BaseMapper;
import com.tokid.model.CProgressQuery;

import java.util.List;
import java.util.Map;

public interface CProgressQueryMapper extends BaseMapper<CProgressQuery>{

    List<Map<String, Object>> getList(Map<String, Object> map) throws ServiceException;

}
