package com.tokid.base.config.shiro;
/*
* @Description: shiro配置
* @author king
* @date 2017/12/13 10:46
*/

import com.tokid.base.customUtils.YamlLoadUtil;
import org.apache.log4j.Logger;
import org.springframework.core.env.PropertySource;

public class ShiroUrlConfig {

    Logger logg= Logger.getLogger(ShiroUrlConfig.class);

    private ShiroUrlConfig(){
        PropertySource propertySource = YamlLoadUtil.getYamlLoad("classpath:application.yml");
        this.login = propertySource.getProperty("shiro.url.login").toString();
        this.logout = propertySource.getProperty("shiro.url.logout").toString();
        this.index = propertySource.getProperty("shiro.url.index").toString();
        this.forbidden = propertySource.getProperty("shiro.url.forbidden").toString();
        this.unAuthorized = propertySource.getProperty("shiro.url.unAuthorized").toString();
        this.unLogin = propertySource.getProperty("shiro.url.unLogin").toString();
        logg.info("shiroUrlConfig---" + propertySource);
    }

    public static ShiroUrlConfig shiroUrlConfig = new ShiroUrlConfig();

    public static synchronized ShiroUrlConfig getInstance(){
        return  shiroUrlConfig;
    }

    private String login;

    private String logout;

    private String index;

    private String forbidden;

    private String unAuthorized;

    private String unLogin;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogout() {
        return logout;
    }

    public void setLogout(String logout) {
        this.logout = logout;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getForbidden() {
        return forbidden;
    }

    public void setForbidden(String forbidden) {
        this.forbidden = forbidden;
    }

    public String getUnAuthorized() {
        return unAuthorized;
    }

    public void setUnAuthorized(String unAuthorized) {
        this.unAuthorized = unAuthorized;
    }

    public String getUnLogin() {
        return unLogin;
    }

    public void setUnLogin(String unLogin) {
        this.unLogin = unLogin;
    }
}
