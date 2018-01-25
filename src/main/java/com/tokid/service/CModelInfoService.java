package com.tokid.service;
/*
* @Description: TODO
* @author king
* @date 2018/1/24 15:48
*/

import com.tokid.base.exception.ServiceException;
import com.tokid.base.service.BaseService;
import com.tokid.mapper.CModelInfoMapper;
import com.tokid.model.CModelInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CModelInfoService extends BaseService<CModelInfo,Long> {

    @Autowired
    private CModelInfoMapper cModelInfoMapper;

     public List<Map<String, Object>> getList(Map<String, Object> map) throws ServiceException {
        return cModelInfoMapper.getList(map);
    }

}
