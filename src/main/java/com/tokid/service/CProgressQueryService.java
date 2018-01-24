package com.tokid.service;
/*
* @Description: TODO
* @author king
* @date 2018/1/24 16:37
*/


import com.tokid.base.service.BaseService;
import com.tokid.mapper.CProgressQueryMapper;
import com.tokid.model.CProgressQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CProgressQueryService extends BaseService<CProgressQuery, Long>{

    @Autowired
    private CProgressQueryMapper cProgressQueryMapper;

}
