package com.tokid.service;
/*
* @Description: TODO
* @author king
* @date 2018/1/24 13:51
*/

import com.tokid.base.exception.ServiceException;
import com.tokid.base.service.BaseService;
import com.tokid.mapper.CClientMapper;
import com.tokid.model.CClient;
import com.tokid.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CClientService extends BaseService<CClient, Long> {

    @Autowired
    private CClientMapper cClientMapper;

    public List<Permission> getAllClient(Map<String, Object> map) throws ServiceException{
        return cClientMapper.getAllClient(map);
    }
}
