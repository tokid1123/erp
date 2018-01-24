package com.tokid.service;
/*
* @Description: TODO
* @author king
* @date 2018/1/24 16:48
*/

import com.tokid.base.service.BaseService;
import com.tokid.mapper.CScrappedQueryMapper;
import com.tokid.model.CScrappedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CScrappedQueryService extends BaseService<CScrappedQuery, Long>{

    @Autowired
    private CScrappedQueryMapper cScrappedQueryMapper;

}
