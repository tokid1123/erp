package com.tokid.mapper;
/*
* @Description: TODO
* @author king
* @date 2018/1/24 15:49
*/

import com.tokid.base.exception.ServiceException;
import com.tokid.base.mapper.BaseMapper;
import com.tokid.model.CModelInfo;

import java.util.List;
import java.util.Map;

public interface CModelInfoMapper extends BaseMapper<CModelInfo> {

    List<Map<String, Object>> getList(Map<String, Object> map) throws ServiceException;

}
