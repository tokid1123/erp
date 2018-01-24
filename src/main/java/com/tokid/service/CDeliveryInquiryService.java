package com.tokid.service;
/*
* @Description: TODO
* @author king
* @date 2018/1/24 16:05
*/


import com.tokid.base.service.BaseService;
import com.tokid.mapper.CDeliveryInquiryMapper;
import com.tokid.model.CClient;
import com.tokid.model.CDeliveryInquiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CDeliveryInquiryService extends BaseService<CDeliveryInquiry, Long> {

    @Autowired
    private CDeliveryInquiryMapper cDeliveryInquiryMapper;

}
