package com.tokid.mapper;
/*
* @Description: TODO
* @author king
* @date 2018/1/24 16:20
*/

import com.tokid.base.exception.ServiceException;
import com.tokid.base.mapper.BaseMapper;
import com.tokid.model.COrder;

import java.util.List;
import java.util.Map;

public interface COrderMapper extends BaseMapper<COrder>{

    List<Map<String, Object>> getList(Map<String, Object> map) throws ServiceException;

}
