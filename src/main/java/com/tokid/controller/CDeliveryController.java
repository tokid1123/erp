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
            map.put("keh_j", body.get("keh_j"));//搜索条件:客户名称
            map.put("id_chpch_m", body.get("id_chpch_m"));//型号id
            map.put("chpch_bh", body.get("chpch_bh"));//送货单号
            map.put("pingm_bh", body.get("pingm_bh"));//产品编码
            map.put("pingm", body.get("pingm"));//产品名称
            map.put("liaoh", body.get("liaoh"));//物料编号
            map.put("keh_po", body.get("keh_po"));//订单PO
            result = Result.createSuccessResultForm(cDeliveryInquiryService.getList(map), ResultEnum.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(ResultEnum.ERROR);
        }
        return result;
    }

}
