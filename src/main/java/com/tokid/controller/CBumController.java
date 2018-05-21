package com.tokid.controller;/*
* @Description: TODO
* @author king
* @date 2018/4/14  14:14
*/


import com.tokid.base.customUtils.JsonRequestBody;
import com.tokid.base.customUtils.Result;
import com.tokid.base.customUtils.ResultEnum;
import com.tokid.base.customUtils.UserLoginUtils;
import com.tokid.base.utils.MapUtils;
import com.tokid.model.CBum;
import com.tokid.model.CClient;
import com.tokid.service.CBumService;
import com.tokid.service.CClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/cBum")
@RestController
public class CBumController {

    @Autowired
    private CBumService cBumService;

    @RequestMapping("/getList")
    public Object getList(@RequestBody JsonRequestBody body) {
        Result<?> result;
        try {
            String bum_j = String.valueOf(body.get("bum_j"));
            Map <String, Object> map = MapUtils.newHashMap();
            map.put("bum_j", bum_j);
            result = Result.createSuccessResultForm(cBumService.getList(map), ResultEnum.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(ResultEnum.ERROR);
        }
        return result;
    }

}
