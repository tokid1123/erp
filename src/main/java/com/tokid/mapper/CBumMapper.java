package com.tokid.mapper;/*
* @Description: TODO
* @author king
* @date 2018/4/14  14:06
*/

import com.tokid.base.exception.ServiceException;
import com.tokid.base.mapper.BaseMapper;
import com.tokid.model.CBum;

import java.util.List;
import java.util.Map;

public interface CBumMapper extends BaseMapper<CBum> {

    List<Map<String, Object>> getList(Map<String, Object> map) throws ServiceException;
}
