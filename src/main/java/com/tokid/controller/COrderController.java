package com.tokid.controller;/*
* @Description: TODO
* @author king
* @date 2018/1/24  23:34
*/


import com.tokid.base.customUtils.JsonRequestBody;
import com.tokid.base.customUtils.Result;
import com.tokid.base.customUtils.ResultEnum;
import com.tokid.base.customUtils.UserLoginUtils;
import com.tokid.base.utils.MapUtils;
import com.tokid.model.CModelInfo;
import com.tokid.model.COrder;
import com.tokid.service.COrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/order")
public class COrderController {

    @Autowired
    private COrderService cOrderService;

    @RequestMapping("/get")
    public Object get(@RequestBody JsonRequestBody body) {
        Result<?> result;
        try {
            COrder cOrder = body.tryGet(COrder.class);
            cOrder = cOrderService.selectOne(cOrder);//订单id
            result = Result.createSuccessResultForm(cOrder, ResultEnum.SUCCESS);
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
            map.put("keh_po", body.get("keh_po"));//搜索条件：订单PO
            map.put("id_dind_b", body.get("id_dind_b"));//搜索条件：订单id
            map.put("id_dind_m", body.get("id_dind_m"));//搜索条件：型号id
            map.put("keh_j", body.get("keh_j"));//搜索条件：客户名称
            map.put("pingm_bh", body.get("pingm_bh"));//搜索条件：产品编号
            map.put("pingm", body.get("pingm"));//搜索条件：产品名称
            map.put("liaoh", body.get("liaoh"));//搜索条件：物料编号
            result = Result.createSuccessResultForm(cOrderService.getList(map), ResultEnum.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(ResultEnum.ERROR);
        }
        return result;
    }


}
