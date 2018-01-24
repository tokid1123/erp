package com.tokid.controller;
/*
* @Description: TODO
* @author king
* @date 2018/1/24 13:55
*/

import com.tokid.base.customUtils.JsonRequestBody;
import com.tokid.base.customUtils.Result;
import com.tokid.base.customUtils.ResultEnum;
import com.tokid.base.customUtils.UserLoginUtils;
import com.tokid.base.exception.BizException;
import com.tokid.base.utils.MapUtils;
import com.tokid.model.CClient;
import com.tokid.service.CClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RequestMapping("/client")
@RestController
public class CClientController {

    @Autowired
    private CClientService cClientService;

    @RequestMapping("/get")
    public Object get(@RequestBody JsonRequestBody body) {
        Result<?> result;
        try {
            CClient client = body.tryGet(CClient.class);
            result = Result.createSuccessResultForm(cClientService.selectOne(client), ResultEnum.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(ResultEnum.ERROR);
        }
        return result;
    }

    @RequestMapping("/getClientList")
    public Object getClientList(@RequestBody JsonRequestBody body) {
        Result<?> result;
        try {
            Map <String, Object> map = MapUtils.newHashMap();
            map.put("username", UserLoginUtils.getCurrentUsername());
            map.put("", "");//搜索条件
            result = Result.createSuccessResultForm(cClientService.getAllClient(map), ResultEnum.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(ResultEnum.ERROR);
        }
        return result;
    }


}

