package com.tokid.controller;
/*
* @Description: TODO
* @author king
* @date 2017/11/24 14:44
*/

import com.tokid.base.exception.BizException;
import com.tokid.base.utils.Result;
import com.tokid.base.utils.ResultEnum;
import com.tokid.model.Permission;
import com.tokid.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/permission")
@RestController
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/saveOrUpdate")
    public Object saveOrUpdate(@RequestBody Permission permission){
        Result<?> result;
        try {
            if (permission.getPermission() == null){
                throw new BizException("permission is null");
            }if (permission.getResourceType() == null){
                throw new BizException("resourceType is null");
            }if (permission.getUrl() == null){
                throw new BizException("url is null");
            }
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
            if (id == null) {
                throw new BizException("id is null");
            }
            result = Result.createSuccessResultForm(permissionService.deletes(id), ResultEnum.success);
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(ResultEnum.error);
        }
        return result;
    }


}
