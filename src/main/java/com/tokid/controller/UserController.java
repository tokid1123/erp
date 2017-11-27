package com.tokid.controller;
/*
* @Description: TODO 获取用户分页列表没做完，保存删除用户，没保存删除用户角色关系（批量删除用户关系）  用户username， name相同要判断
* @author king
* @date 2017/11/20 15:59
*/

import com.tokid.base.exception.BizException;
import com.tokid.base.utils.Result;
import com.tokid.base.utils.ResultEnum;
import com.tokid.base.utils.StringUtils;
import com.tokid.model.User;
import com.tokid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/saveOrUpdate")
    public Object saveOrUpdate(@RequestBody User user) {
        Result<?> result;
        try {
            //业务验证放在service
            if (user == null)
                throw new BizException("user is null");
            if (StringUtils.isBlank(user.getName()))
                throw new BizException("name is null");
            if (StringUtils.isBlank(user.getUsername()))
                throw new BizException("username is null");
            if (StringUtils.isBlank(user.getPassword()))
                throw new BizException("password is null");

            result = Result.createSuccessResultForm(userService.saveOrUpdate(user), ResultEnum.success);
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

            result = Result.createSuccessResultForm(userService.deletes(id), ResultEnum.success);
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

            result = Result.createSuccessResultForm(userService.selectById(id), ResultEnum.success);
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(ResultEnum.error);
        }
        return result;
    }

    @RequestMapping("/getUser")
    public Object getUser(@RequestBody User user) {
        Result<?> result;
        try {
            result = Result.createSuccessResultForm(userService.selectOne(user), ResultEnum.success);
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
            result = Result.createSuccessResultForm(userService.selectAll());
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.createErrorResultForm(ResultEnum.error);
        }
        return result;
    }

}
