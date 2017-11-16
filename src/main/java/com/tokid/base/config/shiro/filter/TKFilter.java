package com.tokid.base.config.shiro.filter;
/*
* @Description: 跨域
* @author king
* @date 2017/11/16 16:02
*/

import com.tokid.base.config.TKConfig;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(3)
public class TKFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        //httpResponse.setHeader("Access-Control-Allow-Origin",httpRequest.getHeader("Origin"));//httpRequest.getHeader("Origin")类似*
        httpResponse.setHeader("Access-Control-Allow-Origin", TKConfig.getInstance().getAccessControlAllowOrigin());
        httpResponse.setHeader("Access-Control-Allow-Methods", TKConfig.getInstance().getAccessControlAllowMethods());
        httpResponse.setHeader("Access-Control-Max-Age", TKConfig.getInstance().getAccessControlMaxAge());
        httpResponse.setHeader("Access-Control-Allow-Headers", TKConfig.getInstance().getAccessControlAllowHeaders());
        chain.doFilter(httpRequest, httpResponse);
    }

    @Override
    public void destroy() {

    }
}
