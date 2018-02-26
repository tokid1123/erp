package com.tokid.base.config.cors;
/*
* @Description: 跨域
* @author king
* @date 2017/11/16 16:02
*/

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Component
public class CorsFilter implements Filter {

    Logger logg = Logger.getLogger(CorsFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (httpRequest.getMethod().equals("OPTIONS")) {
            httpResponse.setStatus(HttpServletResponse.SC_OK);
//            httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        }
//        else if (Arrays.asList(CorsConfig.getInstance().getAccessControlAllowOrigin()).contains(httpRequest.getHeader(CorsConfig.getInstance().getClientHostPortName())))
            //httpResponse.setHeader("Access-Control-Allow-Origin",httpRequest.getHeader("Origin"));//httpRequest.getHeader("Origin")类似*
//        httpResponse.setHeader("Access-Control-Allow-Origin", httpRequest.getHeader(CorsConfig.getInstance().getClientHostPortName()));
        httpResponse.setHeader("Access-Control-Allow-Origin", ((HttpServletRequest) request).getHeader("Origin"));
        httpResponse.setHeader("Access-Control-Allow-Methods", CorsConfig.getInstance().getAccessControlAllowMethods());
        httpResponse.setHeader("Access-Control-Max-Age", CorsConfig.getInstance().getAccessControlMaxAge());
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Headers", CorsConfig.getInstance().getAccessControlAllowHeaders());

        logg.info("调用跨域处理过滤器");
        chain.doFilter(httpRequest, httpResponse);
    }

    @Override
    public void destroy() {

    }
}
