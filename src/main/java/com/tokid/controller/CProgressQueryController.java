package com.tokid.controller;
/*
* @Description: TODO
* @author king
* @date 2018/1/25 9:56
*/

import com.tokid.base.customUtils.JsonRequestBody;
import com.tokid.base.customUtils.Result;
import com.tokid.base.customUtils.ResultEnum;
import com.tokid.base.customUtils.UserLoginUtils;
import com.tokid.base.utils.MapUtils;
import com.tokid.model.COrder;
import com.tokid.model.CProgressQuery;
import com.tokid.service.CProgressQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/progress")
public class CProgressQueryController {

    @Autowired
    private CProgressQueryService cProgressQueryService;


    @RequestMapping("/get")
    public Object get(@RequestBody JsonRequestBody body) {
        Result<?> result;
        try {
            CProgressQuery cProgressQuery = body.tryGet(CProgressQuery.class);
            cProgressQuery = cProgressQueryService.selectOne(cProgressQuery);//进度查询id
            result = Result.createSuccessResultForm(cProgressQuery, ResultEnum.SUCCESS);
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
            result = Result.createSuccessResultForm(cProgressQueryService.getList(map), ResultEnum.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(ResultEnum.ERROR);
        }
        return result;
    }
}
