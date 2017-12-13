package com.tokid.base.config.cors;

import com.tokid.base.customUtils.YamlLoadUtil;
import org.springframework.core.env.PropertySource;

/*
* @author king
* @date 2017/11/16 15:23
*/
public class CorsConfig {

    private CorsConfig() {
        PropertySource propertySource = YamlLoadUtil.getYamlLoad("classpath:application.yml");
        this.tokenHeaderName = propertySource.getProperty("shiro.cors.tokenHeaderName").toString();
        this.clientHostPortName = propertySource.getProperty("shiro.cors.clientHostPortName").toString();
        this.accessControlAllowMethods = propertySource.getProperty("shiro.cors.accessControlAllowMethods").toString();
        this.accessControlAllowHeaders = propertySource.getProperty("shiro.cors.accessControlAllowHeaders").toString();
        this.accessControlMaxAge = propertySource.getProperty("shiro.cors.accessControlMaxAge").toString();
        this.accessControlAllowOrigin = propertySource.getProperty("shiro.cors.accessControlAllowOrigin").toString().split(",");
    }

    public static CorsConfig corsConfig = new CorsConfig();

    public static synchronized CorsConfig getInstance(){
        return corsConfig;
    }


    private String[] accessControlAllowOrigin;

    //存放token的表头名称
    private String tokenHeaderName;

    //存放客户端地址的表头
    private String clientHostPortName;

    private String accessControlAllowMethods;

    private String accessControlAllowHeaders;

    private String accessControlMaxAge;

    public String getClientHostPortName() {
        return clientHostPortName;
    }

    public void setClientHostPortName(String clientHostPortName) {
        this.clientHostPortName = clientHostPortName;
    }

    public String[] getAccessControlAllowOrigin() {
        return accessControlAllowOrigin;
    }

    public void setAccessControlAllowOrigin(String[] accessControlAllowOrigin) {
        this.accessControlAllowOrigin = accessControlAllowOrigin;
    }

    public String getTokenHeaderName() {
        return tokenHeaderName;
    }

    public void setTokenHeaderName(String tokenHeaderName) {
        this.tokenHeaderName = tokenHeaderName;
    }

    public String getAccessControlAllowMethods() {
        return accessControlAllowMethods;
    }

    public void setAccessControlAllowMethods(String accessControlAllowMethods) {
        this.accessControlAllowMethods = accessControlAllowMethods;
    }

    public String getAccessControlAllowHeaders() {
        return accessControlAllowHeaders;
    }

    public void setAccessControlAllowHeaders(String accessControlAllowHeaders) {
        this.accessControlAllowHeaders = accessControlAllowHeaders;
    }

    public String getAccessControlMaxAge() {
        return accessControlMaxAge;
    }

    public void setAccessControlMaxAge(String accessControlMaxAge) {
        this.accessControlMaxAge = accessControlMaxAge;
    }
}
