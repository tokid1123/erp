package com.tokid.mapper;

import com.tokid.base.exception.ServiceException;
import com.tokid.base.mapper.BaseMapper;
import com.tokid.model.CDataSource;

import java.util.List;
import java.util.Map;

public interface CDataSourceMapper extends BaseMapper<CDataSource> {

    List<Map<String,Object>> getList(Map<String, Object> map) throws ServiceException;
}
