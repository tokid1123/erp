package com.tokid.controller;
/*
* @Description: TODO 分页没有完成 角色创建要关联权限，删除同
* @author king
* @date 2017/11/24 14:41
*/

import com.tokid.base.exception.BizException;
import com.tokid.base.utils.Result;
import com.tokid.base.utils.ResultEnum;
import com.tokid.base.utils.StringUtils;
import com.tokid.model.Property;
import com.tokid.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @RequestMapping("/saveOrUpdate")
    public Object saveOrUpdate(@RequestBody Property property) {
        Result<?> result;
        try {
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
    public Object delete(@RequestBody Long id) {
        Result<?> result;
        try {
            if (id == null)
                throw new BizException("id is null");

            result = Result.createSuccessResultForm(propertyService.deletes(id), ResultEnum.success);
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

            result = Result.createSuccessResultForm(propertyService.selectById(id), ResultEnum.success);
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
            result = Result.createSuccessResultForm(propertyService.selectAll());
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(ResultEnum.error);
        }
        return result;
    }

}
