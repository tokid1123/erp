package com.tokid.dynamic;

import com.tokid.base.service.BaseService;
import com.tokid.mapper.CDataSourceMapper;
import com.tokid.model.CDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CDataSourceService extends BaseService<CDataSource, Integer> {

    @Autowired
    private CDataSourceMapper cDataSourceMapper;

}
