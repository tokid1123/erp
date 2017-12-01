package com.tokid.base.config;

import com.tokid.base.customUtils.YamlLoadUtil;
import org.springframework.core.env.PropertySource;

/*
* @author king
* @date 2017/11/16 15:23
*/
public class TKConfig {

    private TKConfig() {
        PropertySource propertySource = YamlLoadUtil.getYamlLoad("classpath:application.yml");
        this.tokenHeaderName = propertySource.getProperty("shiro.tokenHeaderName").toString();
        this.accessControlAllowMethods = propertySource.getProperty("shiro.accessControlAllowMethods").toString();
        this.accessControlAllowHeaders = propertySource.getProperty("shiro.accessControlAllowHeaders").toString();
        this.accessControlMaxAge = propertySource.getProperty("shiro.accessControlMaxAge").toString();
        this.accessControlAllowOrigin = propertySource.getProperty("shiro.accessControlAllowOrigin").toString();
    }

    public static TKConfig tkConfig= new TKConfig();

    public static synchronized TKConfig getInstance(){
        return tkConfig;
    }


    private String accessControlAllowOrigin;

    private String tokenHeaderName;

    private String accessControlAllowMethods;

    private String accessControlAllowHeaders;

    private String accessControlMaxAge;

    public String getAccessControlAllowOrigin() {
        return accessControlAllowOrigin;
    }

    public void setAccessControlAllowOrigin(String accessControlAllowOrigin) {
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
