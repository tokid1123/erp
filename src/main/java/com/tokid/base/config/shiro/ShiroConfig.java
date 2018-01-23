package com.tokid.base.config.shiro;
/*
* @Description:
* @author king
* @date 2017/11/15 10:21
*
*  * Shiro 配置
 *
Apache Shiro 核心通过 Filter 来实现，就好像SpringMvc 通过DispachServlet 来主控制一样。
既然是使用 Filter 一般也就能猜到，是通过URL规则来进行过滤和权限校验，所以我们需要定义一系列关于URL的规则和访问权限。
*
*/

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在
     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     *
     Filter Chain定义说明
     1、一个URL可以配置多个Filter，使用逗号分隔
     2、当设置多个过滤器时，全部验证通过，才视为通过
     3、部分过滤器可指定参数，如perms，roles
     *
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        //System.out.println("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean  = new ShiroFilterFactoryBean();

        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);



        //拦截器.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();

        //配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了

        filterChainDefinitionMap.put(ShiroUrlConfig.getInstance().getLogin(), "anon");
        filterChainDefinitionMap.put(ShiroUrlConfig.getInstance().getLogout(), "anon");
        filterChainDefinitionMap.put(ShiroUrlConfig.getInstance().getForbidden(), "anon");

        //<!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/**", "authc");

        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl(ShiroUrlConfig.getInstance().getUnLogin());
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl(ShiroUrlConfig.getInstance().getIndex());
        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl(ShiroUrlConfig.getInstance().getUnAuthorized());

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        //自定义过滤器
        Map<String, Filter> filters = new HashMap<>();
        filters.put("authc", new JWTOrAuthenticationFilter());
        shiroFilterFactoryBean.setFilters(filters);
        return shiroFilterFactoryBean;
    }


    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        securityManager.setSessionManager(new SessionManager());
        //注入缓存管理器;
        securityManager.setCacheManager(ehCacheManager());//这个如果执行多次，也是同样的一个对象;
        return securityManager;
    }

    /**
     * shiro缓存管理器;
     * 需要注入对应的其它的实体类中：
     * 1、安全管理器：securityManager
     * 可见securityManager是整个shiro的核心；
     * @return
     */
    @Bean
    public EhCacheManager ehCacheManager(){
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:config/ehcache-shiro.xml");
        return cacheManager;
    }

    /**
     * 身份认证realm;
     * (这个需要自己写，账号密码校验；权限等)
     */
    @Bean
    public MyShiroRealm myShiroRealm(){
        return new MyShiroRealm();
    }
}
