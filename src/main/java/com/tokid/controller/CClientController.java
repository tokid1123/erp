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
            client = cClientService.selectOne(client);//客户id   id_keh
            result = Result.createSuccessResultForm(client, ResultEnum.SUCCESS);
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
            Map <String, Object> map = MapUtils.newHashMap();
            map.put("username", UserLoginUtils.getCurrentUsername());
            map.put("keh_j", body.get("keh_j"));//搜索条件:客户名称
            map.put("keh_bh", body.get("keh_bh"));//客户代码
            map.put("yewy", body.get("yewy"));//业务员
            map.put("keh_q_gs", body.get("keh_q_gs"));//客户全称
            map.put("weny", body.get("weny"));//文员
            map.put("hezuo_lb", body.get("hezuo_lb"));//合作方式
            map.put("keh_j_2", body.get("keh_j_2"));//客户简称2
            result = Result.createSuccessResultForm(cClientService.getList(map), ResultEnum.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(ResultEnum.ERROR);
        }
        return result;
    }


}

