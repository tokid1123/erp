package com.tokid.controller;
/*
* @Description: TODO
* @author king
* @date 2018/1/25 9:48
*/


import com.tokid.base.customUtils.JsonRequestBody;
import com.tokid.base.customUtils.Result;
import com.tokid.base.customUtils.ResultEnum;
import com.tokid.base.customUtils.UserLoginUtils;
import com.tokid.base.utils.MapUtils;
import com.tokid.model.CClient;
import com.tokid.model.CDeliveryInquiry;
import com.tokid.service.CDeliveryInquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/delivery")
public class CDeliveryController {

    @Autowired
    private CDeliveryInquiryService cDeliveryInquiryService;

    @RequestMapping("/get")
    public Object get(@RequestBody JsonRequestBody body) {
        Result<?> result;
        try {
            CDeliveryInquiry cDeliveryInquiry = body.tryGet(CDeliveryInquiry.class);
            cDeliveryInquiry = cDeliveryInquiryService.selectOne(cDeliveryInquiry);//送货信息id
            result = Result.createSuccessResultForm(cDeliveryInquiry, ResultEnum.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(ResultEnum.ERROR);
        }
        return result;
    }

    @RequestMapping("/getList")
    public Object getList(@RequestBody JsonRequestBody body) {
        Result<?> result;
        try {
            Map<String, Object> map = MapUtils.newHashMap();
            map.put("username", UserLoginUtils.getCurrentUsername());
            map.put("clientName", body.get("clientName"));//搜索条件:客户名称
            result = Result.createSuccessResultForm(cDeliveryInquiryService.getList(map), ResultEnum.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(ResultEnum.ERROR);
        }
        return result;
    }

}
