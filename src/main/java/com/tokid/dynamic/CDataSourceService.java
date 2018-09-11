package com.tokid.dynamic;

import com.tokid.base.exception.ServiceException;
import com.tokid.base.service.BaseService;
import com.tokid.mapper.CDataSourceMapper;
import com.tokid.model.CDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CDataSourceService extends BaseService<CDataSource, String> {

    @Autowired
    private CDataSourceMapper cDataSourceMapper;

    public List<Map<String, Object>> getList(Map<String, Object> map) throws ServiceException {
        List<Map<String, Object>> list = cDataSourceMapper.getList(map);
        return list;
    }

}
