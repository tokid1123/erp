package com.tokid.service;
/*
* @Description:
* @author king
* @date 2017/11/19 11:05
*/

import com.tokid.base.cache.CacheManager;
import com.tokid.base.customUtils.Result;
import com.tokid.base.customUtils.ResultEnum;
import com.tokid.base.customUtils.UserLoginUtils;
import com.tokid.base.exception.ServiceException;
import com.tokid.base.model.LoginUser;
import com.tokid.base.service.BaseService;
import com.tokid.base.utils.MapUtils;
import com.tokid.base.utils.SequenceUtils;
import com.tokid.model.Permission;
import com.tokid.model.User;
import com.tokid.model.UserProperty;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserService extends BaseService<User, Long> {

    @Autowired
    private UserPropertyService userPropertyService;
    @Autowired
    private PermissionService permissionService;

    public Long saveOrUpdate(User user) throws ServiceException {
        Long id = null;
        if (user.getId() != null) {//编辑状态
            user.setPassword(user.getPassword() == null ? UserLoginUtils.DEFAUTE_PASSWORD : user.getPassword());
            //user.setUpdateBy(UserLoginUtils.getCurrentUserId());
            user.setUpdateTime(new Date());
            id = this.update(user);
        } else {
            //user.setCreateBy(UserLoginUtils.getCurrentUserId());
            user.setCreateTime(new Date());
            user.setState(1);
            user.setCode(SequenceUtils.getSecondUID("U"));
            id = this.insert(user);
        }
        return id;
    }

    @Transactional
    public Object delete(Long userId) {
        int count = this.deleteByPrimaryKey(userId);//删除用户
        //删除用户角色关系
        UserProperty userProperty = new UserProperty();
        userProperty.setUserId(userId);
        userProperty = userPropertyService.selectOne(userProperty);
        if (userProperty.getId() != null) {
            count = userPropertyService.delete(userProperty);
        }
        return count;
    }

    /**
     * 退出登录
     *
     * @return
     */
    public void logout() {
        Subject subject = SecurityUtils.getSubject(); // 获取Subject单例对象
        subject.logout(); // 退出
    }

    @Transactional
    public Result login(User user) throws ServiceException {
        //判断是否为空
        if (user == null || user.getUsername() == null || "".equals(user.getUsername()) || user.getPassword() == null || "".equals(user.getPassword()))
            return Result.createErrorResultForm(null, ResultEnum.LOGIN_ERROR_UN_EXIST_NAME_PASSWORD);

        //查询
        User userSearch = new User();
        userSearch.setUsername(user.getUsername());
        userSearch.setPassword(user.getPassword());
        userSearch.setState(1);

        User dataUser = selectOne(userSearch);
        if (dataUser == null)
            return Result.createErrorResultForm(null, ResultEnum.LOGIN_ERROR_FALIE_NAME_PASSWORD);

        //获取token
        UsernamePasswordToken token = new UsernamePasswordToken(userSearch.getUsername(), userSearch.getPassword());

        Subject subject = SecurityUtils.getSubject(); // 获取Subject单例对象
        SecurityUtils.getSubject().getSession().setTimeout(604800000);//设置session有效期7天
        //SecurityUtils.getSubject().getSession().setTimeout(10000);//设置session有效期7天
        subject.login(token); // 登陆
        //设置session对象
        LoginUser loginUser = new LoginUser();
        loginUser.setUser(dataUser);
        loginUser.setLoginTime(new Date());

        Map<String, Object> map = MapUtils.newHashMap();
        map.put("userId",dataUser.getId());
        List<Permission> permissionList = permissionService.getAllPermissions(map);

        //设置缓存
        subject.getSession().setAttribute(UserLoginUtils.LOGIN_USER_SESSION_NAME, loginUser);
        subject.getSession().setAttribute(UserLoginUtils.LOGIN_USER_MENUS_NAME, permissionList);

        CacheManager cacheManager =  CacheManager.getInstance();
        cacheManager.put(user.getUsername(),subject.getSession().getId());

        return Result.createSuccessResultForm(subject.getSession().getId(), ResultEnum.SUCCESS);
    }
}
