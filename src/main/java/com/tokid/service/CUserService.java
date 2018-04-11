package com.tokid.service;
/*
* @Description: TODO
* @author king
* @date 2018/1/24 10:36
*/

import com.tokid.base.cache.CacheManager;
import com.tokid.base.customUtils.Result;
import com.tokid.base.customUtils.ResultEnum;
import com.tokid.base.customUtils.UserLoginUtils;
import com.tokid.base.exception.ServiceException;
import com.tokid.base.service.BaseService;
import com.tokid.model.CLoginUser;
import com.tokid.model.CUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CUserService extends BaseService<CUser, Long>{


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
    public Result login(CUser user) throws ServiceException {
        //判断是否为空
        if (user == null || user.getUsername() == null || "".equals(user.getUsername()) || user.getPassword() == null || "".equals(user.getPassword()))
            return Result.createErrorResultForm(null, ResultEnum.LOGIN_ERROR_UN_EXIST_NAME_PASSWORD);

        //查询
        CUser userSearch = new CUser();
        userSearch.setUsername(user.getUsername());
        userSearch.setPassword(user.getPassword());


        CUser dataUser = selectOne(userSearch);
        if (dataUser == null)
            return Result.createErrorResultForm(null, ResultEnum.LOGIN_ERROR_FALIE_NAME_PASSWORD);

        //获取token
        UsernamePasswordToken token = new UsernamePasswordToken(userSearch.getUsername(), userSearch.getPassword());

        Subject subject = SecurityUtils.getSubject(); // 获取Subject单例对象
        SecurityUtils.getSubject().getSession().setTimeout(604800000);//设置session有效期7天
        //SecurityUtils.getSubject().getSession().setTimeout(10000);//设置session有效期7天
        subject.login(token); // 登陆

        CLoginUser loginUser = new CLoginUser();
        loginUser.setUser(dataUser);
        loginUser.setToken(String.valueOf(subject.getSession().getId()));

        //设置缓存,将登陆的用户存到session中
        subject.getSession().setAttribute(UserLoginUtils.LOGIN_USER_SESSION_NAME, dataUser);

        CacheManager cacheManager =  CacheManager.getInstance();
        cacheManager.put(user.getUsername(),subject.getSession().getId());

        return Result.createSuccessResultForm(loginUser, ResultEnum.SUCCESS);
    }

}
