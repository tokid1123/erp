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
            map.put("keh_j", body.get("keh_j"));//搜索条件:客户名称
            map.put("id_bum", body.get("id_bum"));//bum_ID
            map.put("chn1_wf2", body.get("chn1_wf2"));//本厂或者外发
            map.put("shch_bh", body.get("shch_bh"));//指令号
            map.put("bum_j", body.get("bum_j"));//工序
            map.put("pingm_bh", body.get("pingm_bh"));//产品编号
            map.put("pingm", body.get("pingm"));//产品名称
            map.put("liaoh", body.get("liaoh"));//物料编号
            result = Result.createSuccessResultForm(cProgressQueryService.getList(map), ResultEnum.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(ResultEnum.ERROR);
        }
        return result;
    }
}
