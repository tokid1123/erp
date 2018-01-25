package com.tokid.mapper;
/*
* @Description: TODO
* @author king
* @date 2018/1/24 16:04
*/

import com.tokid.base.exception.ServiceException;
import com.tokid.base.mapper.BaseMapper;
import com.tokid.model.CDeliveryInquiry;

import java.util.List;
import java.util.Map;

public interface CDeliveryInquiryMapper extends BaseMapper<CDeliveryInquiry> {

    List<Map<String, Object>> getList(Map<String, Object> map) throws ServiceException;


}
