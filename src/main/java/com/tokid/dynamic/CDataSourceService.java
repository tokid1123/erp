package com.tokid.dynamic;

import com.tokid.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CDataSourceService extends BaseService<CDataSource, Long> {

    @Autowired
    private CDataSourceMapper cDataSourceMapper;

}
