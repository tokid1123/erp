package com.tokid.controller;
/*
* @Description: TODO 获取分页没有完成
* @author king
* @date 2017/11/24 14:44
*/

import com.tokid.base.exception.BizException;
import com.tokid.base.utils.Result;
import com.tokid.base.utils.ResultEnum;
import com.tokid.base.utils.StringUtils;
import com.tokid.base.json.JsonRequestBody;
import com.tokid.model.Permission;
import com.tokid.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/permission")
@RestController
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/saveOrUpdate")
    public Object saveOrUpdate(@RequestBody JsonRequestBody body) {
        Result<?> result;
        try {
            Permission permission = body.tryGet(Permission.class);
            if (permission == null)
                throw new BizException("permission entity is null");
            if (StringUtils.isBlank(permission.getPermission()))
                throw new BizException("permission is null");
            if (StringUtils.isBlank(permission.getResourceType()))
                throw new BizException("resourceType is null");
            if (StringUtils.isBlank(permission.getUrl()))
                throw new BizException("url is null");

            result = Result.createSuccessResultForm(permissionService.saveOrUpdate(permission), ResultEnum.success);
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(ResultEnum.error);
        }
        return result;
    }

    @RequestMapping("/delete")
    public Object delete(@RequestBody Long id) {
        Result<?> result;
        try {
            if (id == null)
                throw new BizException("id is null");

            result = Result.createSuccessResultForm(permissionService.deletes(id), ResultEnum.success);
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(ResultEnum.error);
        }
        return result;
    }

    @RequestMapping("/get")
    public Object getById(@RequestBody Long id) {
        Result<?> result;
        try {
            if (id == null)
                throw new BizException("id is null");

            result = Result.createSuccessResultForm(permissionService.selectById(id), ResultEnum.success);
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(ResultEnum.error);
        }
        return result;
    }

    //获取分页用户列表
    @RequestMapping("/getList")
    public Object getList(@RequestBody Map<String, String> map) {
        Result<?> result;
        try {
            result = Result.createSuccessResultForm(permissionService.selectAll());
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(ResultEnum.error);
        }
        return result;
    }

}