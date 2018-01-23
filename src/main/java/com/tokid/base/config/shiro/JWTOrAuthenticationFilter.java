package com.tokid.base.config.shiro;
/*
* @Description:
* @author king
* @date 2017/11/16 16:00
*/

import com.tokid.base.cache.CacheManager;
import com.tokid.base.config.cors.CorsConfig;
import com.tokid.base.customUtils.UserLoginUtils;
import com.tokid.base.model.LoginUser;
import com.tokid.base.utils.StringUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JWTOrAuthenticationFilter extends FormAuthenticationFilter {

    public JWTOrAuthenticationFilter() {

    }

    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpRequest = WebUtils.toHttp(request);
        HttpServletResponse httpResponse = WebUtils.toHttp(response);
        if (httpRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            //原来CROS(跨域)复杂请求时会先发送一个OPTIONS请求，来测试服务器是否支持本次请求，
            // 这个请求时不带数据的，请求成功后才会发送真实的请求。所以前面那个只发送key的问题是要确认服务器支不支持接收这个header。
            // 所以每次获取不到数据的请求都是OPTIONS请求😓。所以我们要做的就是把所有的OPTIONS请求统统放行。
            httpResponse.setHeader("Access-control-Allow-Origin", httpRequest.getHeader(CorsConfig.getInstance().getClientHostPortName()));//获取客户端表头的ip
            httpResponse.setHeader("Access-Control-Allow-Methods", CorsConfig.getInstance().getAccessControlAllowMethods());
            httpResponse.setHeader("Access-Control-Allow-Headers", CorsConfig.getInstance().getAccessControlAllowHeaders());
            httpResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        //判断有没有登录和权限
        boolean isLogin = super.preHandle(request, response);
        //判断session是否是
        String sessionId = httpRequest.getSession().getId();

        //为正值的时候判断是否
        if (isLogin) {
            LoginUser currentUser = UserLoginUtils.getCurrentUser();
            this.checkSession(currentUser.getUser().getUsername(), sessionId);
        } else {
            throw new Exception("invalid session");
        }

        return super.preHandle(request, response);
    }

    private void checkSession(String name, String sessionId) throws Exception {
        CacheManager cacheManager = CacheManager.getInstance();
        String cacheSessionId = (String) cacheManager.get(name);
        if (StringUtils.isBlank(cacheSessionId) || StringUtils.isNotBlank(cacheSessionId) && !StringUtils.equals(sessionId, cacheSessionId))
            throw new Exception("invalid session");
    }

    private void isAuthorized(ServletRequest request, ServletResponse response) {

    }
}
