package com.tokid.controller;
/*
* @Description: done
* @author king
* @date 2017/11/24 14:41
*/

import com.tokid.base.exception.BizException;
import com.tokid.base.json.JsonRequestBody;
import com.tokid.base.utils.Result;
import com.tokid.base.utils.ResultEnum;
import com.tokid.base.utils.StringUtils;
import com.tokid.model.Property;
import com.tokid.model.PropertyPermission;
import com.tokid.service.PropertyPermissionService;
import com.tokid.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;
    @Autowired
    private PropertyPermissionService propertyPermissionService;

    @RequestMapping("/saveOrUpdate")
    public Object saveOrUpdate(@RequestBody JsonRequestBody body) {
        Result<?> result;
        try {
            Property property = body.tryGet(Property.class);
            if (property == null)
                throw new BizException("property is null");
            if (StringUtils.isBlank(property.getRole()))
                throw new BizException("role is null");
            if (StringUtils.isBlank(property.getName()))
                throw new BizException("name is null");
            if (StringUtils.isBlank(property.getDescription()))
                throw new BizException("description is null");

            result = Result.createSuccessResultForm(propertyService.saveOrUpdate(property), ResultEnum.success);
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(ResultEnum.error);
        }
        return result;
    }

    @RequestMapping("/delete")
    public Object delete(@RequestBody JsonRequestBody body) {
        Result<?> result;
        try {
            Long id = body.getLong("id");
            if (id == null)
                throw new BizException("id is null");

            result = Result.createSuccessResultForm(propertyService.deleteById(id), ResultEnum.success);
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(ResultEnum.error);
        }
        return result;
    }

    @RequestMapping("/get")
    public Object getById(@RequestBody JsonRequestBody body) {
        Result<?> result;
        try {
            Long id = body.getLong("id");
            if (id == null)
                throw new BizException("id is null");

            result = Result.createSuccessResultForm(propertyService.selectById(id), ResultEnum.success);
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(ResultEnum.error);
        }
        return result;
    }

    //获取分页用户列表
    @RequestMapping("/getList")
    public Object getList(@RequestBody JsonRequestBody body) {
        Result<?> result;
        try {
            Property property = body.tryGet(Property.class);
            result = Result.createSuccessResultForm(propertyService.selectPage(body.getPageForm(), property), ResultEnum.success);
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(ResultEnum.error);
        }
        return result;
    }

    /**
     * 给角色配置相应的权限
     */
    @RequestMapping("/setPropertyPermissions")
    public Object setPropertyPermissions(@RequestBody JsonRequestBody body) {
        Result<?> result;
        try {
            Long propertyId = body.getLong("propertyId");
            List<PropertyPermission> list = body.getList("list", PropertyPermission.class);
            if (propertyId == null) {
                throw new BizException("property id is null");
            }
            if (list == null || list.size() <= 0) {
                throw new BizException("list is null");
            }
            result = Result.createSuccessResultForm(propertyPermissionService.saveList(propertyId, list), ResultEnum.success);
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(ResultEnum.error);
        }
        return result;
    }
}
