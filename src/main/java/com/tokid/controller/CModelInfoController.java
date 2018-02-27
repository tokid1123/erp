package com.tokid.controller;/*
* @Description: TODO
* @author king
* @date 2018/1/24  23:10
*/

import com.tokid.base.customUtils.JsonRequestBody;
import com.tokid.base.customUtils.Result;
import com.tokid.base.customUtils.ResultEnum;
import com.tokid.base.customUtils.UserLoginUtils;
import com.tokid.base.utils.MapUtils;
import com.tokid.model.CDeliveryInquiry;
import com.tokid.model.CModelInfo;
import com.tokid.service.CModelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/modelInfo")
public class CModelInfoController {

    @Autowired
    private CModelInfoService cModelInfoService;


    @RequestMapping("/get")
    public Object get(@RequestBody JsonRequestBody body) {
        Result<?> result;
        try {
            CModelInfo cModelInfo = body.tryGet(CModelInfo.class);
            cModelInfo = cModelInfoService.selectOne(cModelInfo);//型号id
            result = Result.createSuccessResultForm(cModelInfo, ResultEnum.SUCCESS);
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
            map.put("pingm", body.get("pingm"));//产品名称
            map.put("id_pingm", body.get("id_pingm"));//型号id
            map.put("pingm_bh", body.get("pingm_bh"));//产品编号
            map.put("liaoh", body.get("liaoh"));//物料编码
            map.put("keh_j", body.get("keh_j"));//客户名称
            map.put("caizh", body.get("caizh"));//材质
            result = Result.createSuccessResultForm(cModelInfoService.getList(map), ResultEnum.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(ResultEnum.ERROR);
        }
        return result;
    }


}
