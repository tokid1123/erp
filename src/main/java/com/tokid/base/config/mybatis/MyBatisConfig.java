package com.tokid.base.config.mybatis;
/*
* @Description: MyBatis基础配置
* @author king
* @date 2017/11/17 16:28
*/

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.github.pagehelper.PageHelper;
import com.tokid.base.utils.MapUtils;
import com.tokid.dynamic.DynamicDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ConfigurationProperties(prefix = "mybatis.config")//注入yml属性值
public class MyBatisConfig{

    private String typeAliasesPackage;

    private String reasonable;

    private String supportMethodsArguments;

    private String returnPageInfo;

    private String params;

    private String mapperLocations;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {
        //LOGGER.debug("生成 SqlSessionFactory");
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        //设置数据源
        sqlSessionFactoryBean.setDataSource(dynamicDataSource());
        //设置Model 路径
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);

        //设置分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();

        properties.setProperty("reasonable", reasonable);
        properties.setProperty("supportMethodsArguments", supportMethodsArguments);
        properties.setProperty("returnPageInfo", returnPageInfo);
        properties.setProperty("params", params);
        pageHelper.setProperties(properties);

        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});
        //设置多数据库厂商支持
        //sqlSessionFactoryBean.setDatabaseIdProvider(vendorDatabaseIdProvider);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperLocations));
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource dbMaster() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public AbstractRoutingDataSource dynamicDataSource() {
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setDefaultTargetDataSource(dbMaster());
        DynamicDataSource.datasourcePoolMap.put(DynamicDataSource.MASTERDB, dbMaster());
        dataSource.setTargetDataSources(DynamicDataSource.datasourcePoolMap);
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }

    public String getTypeAliasesPackage() {
        return typeAliasesPackage;
    }

    public void setTypeAliasesPackage(String typeAliasesPackage) {
        this.typeAliasesPackage = typeAliasesPackage;
    }

    public String getReasonable() {
        return reasonable;
    }

    public void setReasonable(String reasonable) {
        this.reasonable = reasonable;
    }

    public String getSupportMethodsArguments() {
        return supportMethodsArguments;
    }

    public void setSupportMethodsArguments(String supportMethodsArguments) {
        this.supportMethodsArguments = supportMethodsArguments;
    }

    public String getReturnPageInfo() {
        return returnPageInfo;
    }

    public void setReturnPageInfo(String returnPageInfo) {
        this.returnPageInfo = returnPageInfo;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getMapperLocations() {
        return mapperLocations;
    }

    public void setMapperLocations(String mapperLocations) {
        this.mapperLocations = mapperLocations;
    }
}
