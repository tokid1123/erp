package com.tokid.base.config;
/*
* @Description: TODO
* @author king
* @date 2017/11/15 15:22
*/

import com.tokid.model.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class TKShiroRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user  = (User)principalCollection.getPrimaryPrincipal();

        //      User user = userService.findByUsername(username)
        //查询权限并添加
        //authorizationInfo.setRoles(roles);
//        authorizationInfo.setStringPermissions(stringPermissions);
        //设置权限信息.

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
//        UserInfo userInfo = userInfoService.findByUsername(username);
//        System.out.println("----->>userInfo="+userInfo);
//        if(userInfo == null){
//            return null;
//        }

        return new SimpleAuthenticationInfo(token, token.getPassword(), getName());
    }
}
