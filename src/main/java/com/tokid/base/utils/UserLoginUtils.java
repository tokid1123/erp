package com.tokid.base.utils;
/*
* @Description:
* @author king
* @date 2017/11/24 15:10
*/

import com.tokid.base.model.LoginUser;
import org.apache.shiro.SecurityUtils;

public class UserLoginUtils {

    //保存到session的名字
    public static final String LOGIN_USER_SESSION_NAME = "currentUser";
    //用户所拥有的角色的名称
    public static final String LOGIN_USER_ROLES_NAME = "userRoles";
    //用户菜单
    public static final String LOGIN_USER_MENUS_NAME ="userMenus";


    //默认密码
    public static final String DEFAUTE_PASSWORD ="123456";

    /**
     * 得到当前登陆人
     * @return
     */
    public static final LoginUser getCurrentUser(){
        return  (LoginUser) SecurityUtils.getSubject().getSession().getAttribute(LOGIN_USER_SESSION_NAME);
    }

    /**
     * 当前登录人id
     * @return
     */
    public static final Long getCurrentUserId(){
        return getCurrentUser().getUser().getId();
    }
}
