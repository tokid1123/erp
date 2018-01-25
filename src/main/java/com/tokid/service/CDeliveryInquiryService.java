package com.tokid.service;
/*
* @Description: TODO
* @author king
* @date 2018/1/24 16:05
*/


import com.tokid.base.exception.ServiceException;
import com.tokid.base.service.BaseService;
import com.tokid.mapper.CDeliveryInquiryMapper;
import com.tokid.model.CClient;
import com.tokid.model.CDeliveryInquiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CDeliveryInquiryService extends BaseService<CDeliveryInquiry, Long> {

    @Autowired
    private CDeliveryInquiryMapper cDeliveryInquiryMapper;

    public List<Map<String, Object>> getList(Map<String, Object> map) throws ServiceException{
        return cDeliveryInquiryMapper.getList(map);
    }


}
