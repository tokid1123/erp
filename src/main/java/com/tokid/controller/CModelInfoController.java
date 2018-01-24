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


    @RequestMapping("/getModelInfoList")
    public Object getModelInfoList(@RequestBody JsonRequestBody body) {
        Result<?> result;
        try {
            Map<String, Object> map = MapUtils.newHashMap();
            map.put("username", UserLoginUtils.getCurrentUsername());
            map.put("productName", body.get("productName"));//搜索条件
            result = Result.createSuccessResultForm(cModelInfoService.getModelInfoList(map), ResultEnum.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(ResultEnum.ERROR);
        }
        return result;
    }


}
