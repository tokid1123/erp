package com.tokid.controller;
/*
* @Description: TODO
* @author king
* @date 2018/1/25 10:03
*/


import com.tokid.base.customUtils.JsonRequestBody;
import com.tokid.base.customUtils.Result;
import com.tokid.base.customUtils.ResultEnum;
import com.tokid.base.customUtils.UserLoginUtils;
import com.tokid.base.utils.MapUtils;
import com.tokid.model.CProgressQuery;
import com.tokid.model.CScrappedQuery;
import com.tokid.service.CScrappedQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/scrap")
public class CScrappedQueryController {

    @Autowired
    private CScrappedQueryService cScrappedQueryService;


    @RequestMapping("/get")
    public Object get(@RequestBody JsonRequestBody body) {
        Result<?> result;
        try {
            CScrappedQuery cScrappedQuery = body.tryGet(CScrappedQuery.class);
            cScrappedQuery = cScrappedQueryService.selectOne(cScrappedQuery);//报废查询id
            result = Result.createSuccessResultForm(cScrappedQuery, ResultEnum.SUCCESS);
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
            map.put("id_wanch_b", body.get("id_wanch_b"));//搜索条件:id
            map.put("pingm_bh", body.get("pingm_bh"));//产品编号
            map.put("pingm", body.get("pingm"));//产品名称
            map.put("liaoh", body.get("liaoh"));//物料编号
            map.put("bum_j", body.get("bum_j"));//工序
            result = Result.createSuccessResultForm(cScrappedQueryService.getList(map), ResultEnum.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(ResultEnum.ERROR);
        }
        return result;
    }


}
