package com.tokid.base.customUtils;
/*
* @Description:
* @author king
* @date 2017/11/24 15:10
*/

import com.tokid.model.CLoginUser;
import com.tokid.model.CUser;
import org.apache.shiro.SecurityUtils;

public class UserLoginUtils {

    //保存到session的名字
    public static final String LOGIN_USER_SESSION_NAME = "currentUser";

    /**
     * 得到当前登陆人
     * @return
     */
    public static final CLoginUser getCurrentUser(){
        return  (CLoginUser) SecurityUtils.getSubject().getSession().getAttribute(LOGIN_USER_SESSION_NAME);
    }

    /**
     * 当前登录人id
     * @return
     */
    public static final String getCurrentUsername(){
        return getCurrentUser().getUser().getUsername().trim();
    }
}
