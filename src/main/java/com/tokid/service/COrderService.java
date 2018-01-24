package com.tokid.service;
/*
* @Description: TODO
* @author king
* @date 2018/1/24 16:21
*/

import com.tokid.base.exception.ServiceException;
import com.tokid.base.service.BaseService;
import com.tokid.mapper.COrderMapper;
import com.tokid.model.COrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class COrderService extends BaseService<COrder, Long> {

    @Autowired
    private COrderMapper cOrderMapper;

    public List<Map<String, Object>> getOrderList(Map<String, Object> map) throws ServiceException{
        return cOrderMapper.getOrderList(map);
    }

}
