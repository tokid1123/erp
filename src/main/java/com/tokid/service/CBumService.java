package com.tokid.service;/*
* @Description: TODO
* @author king
* @date 2018/4/14  14:07
*/

import com.tokid.base.exception.ServiceException;
import com.tokid.base.service.BaseService;
import com.tokid.mapper.CBumMapper;
import com.tokid.model.CBum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CBumService extends BaseService<CBum, Long> {

    @Autowired
    private CBumMapper cBumMapper;

    public List<Map<String, Object>> getList(Map<String, Object> map) throws ServiceException {
        List<Map<String, Object>> list = cBumMapper.getList(map);
        return list;
    }

}
