package com.tokid.service;
/*
* @Description: TODO
* @author king
* @date 2018/1/24 16:48
*/

import com.tokid.base.exception.ServiceException;
import com.tokid.base.service.BaseService;
import com.tokid.mapper.CScrappedQueryMapper;
import com.tokid.model.CScrappedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CScrappedQueryService extends BaseService<CScrappedQuery, Long>{

    @Autowired
    private CScrappedQueryMapper cScrappedQueryMapper;

    public List<Map<String, Object>> getList(Map<String, Object> map) throws ServiceException{
     return cScrappedQueryMapper.getList(map);
    }

}
