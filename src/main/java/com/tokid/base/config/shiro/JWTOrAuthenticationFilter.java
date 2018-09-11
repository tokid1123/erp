package com.tokid.base.config.shiro;
/*
* @Description:
* @author king
* @date 2017/11/16 16:00
*/

import com.tokid.base.cache.CacheManager;
import com.tokid.base.customUtils.UserLoginUtils;
import com.tokid.base.utils.StringUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class JWTOrAuthenticationFilter extends FormAuthenticationFilter {


    public JWTOrAuthenticationFilter() {

    }

    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpRequest = WebUtils.toHttp(request);

        //判断有没有登录和以及session是否有效
        boolean isLogin = super.preHandle(request, response);
        if (isLogin) {
            String sessionId = httpRequest.getSession().getId();
            this.checkSession(UserLoginUtils.getCurrentUsername(), sessionId);
        } else {
            throw new Exception("invalid session id");
        }
        return super.preHandle(request, response);
    }

    @Override
    public void afterCompletion(ServletRequest request, ServletResponse response, Exception exception) throws Exception {


        super.afterCompletion(request, response, exception);
    }

    private void checkSession(String name, String sessionId) throws Exception {
        CacheManager cacheManager = CacheManager.getInstance();
        String cacheSessionId = (String) cacheManager.get(name);
        if (StringUtils.isBlank(cacheSessionId) || StringUtils.isNotBlank(cacheSessionId) && !StringUtils.equals(sessionId, cacheSessionId))
            throw new Exception("invalid session id");
    }

}
