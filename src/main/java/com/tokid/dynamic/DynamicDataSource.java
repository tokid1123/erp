package com.tokid.dynamic;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.DataSourceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ZHAOTING001 on 2017/2/23.
 */
//@Configuration
public class DynamicDataSource extends AbstractRoutingDataSource {

    Logger logger = LoggerFactory.getLogger(DynamicDataSource.class);

    @Autowired
    private CDataSourceService cDataSourceService;

    public static final Map<Object, Object> datasourcePoolMap = new HashMap<>();

    protected Object determineCurrentLookupKey() {
        logger.info("database changed to:{}",DataSourceContextHolder.getDataSourceName());
        return DataSourceContextHolder.getDataSourceName();
    }

    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);

        super.afterPropertiesSet();
    }

    public void initDataSouce(){
        logger.info("-------------->开始初始化加载创建动态数据源...");
        //获取所有数据源配置信息
        List<CDataSource> dataSourceList = cDataSourceService.selectAll();
        for(CDataSource cDataSource : dataSourceList) {
            //
            DruidDataSource DruidDataSource = new DruidDataSource();
            try {
                DruidDataSource.setDriverClassName(cDataSource.getDriverClassName());
                DruidDataSource.setUrl(cDataSource.getUrl());
                DruidDataSource.setUsername(cDataSource.getUsername());
                DruidDataSource.setPassword(cDataSource.getPassword());
                //
                DruidDataSource.setInitialSize(cDataSource.getInitialSize());
                DruidDataSource.setMinIdle(cDataSource.getMinIdle());
                DruidDataSource.setMaxActive(cDataSource.getMaxActive());

            } catch (DataSourceException e) {
                e.printStackTrace();
            }
            datasourcePoolMap.put(cDataSource.getDbName(), DruidDataSource);

        }
        this.setTargetDataSources(datasourcePoolMap);
        logger.info("-------------->初始化加载创建动态数据源完毕，加载数："+datasourcePoolMap.size());
    }

    public void addDatasource(String dbName, String username, String password, String url){
        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/" + dbName);
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://" + url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        datasourcePoolMap.put(dbName, dataSource);
        this.setTargetDataSources(datasourcePoolMap);
//        DataSourceContextHolder.setDataSourceType(dbName);
        logger.info("-------------->动态添加数据源，数据源数："+datasourcePoolMap.size());
    }

    @Override
    public void afterPropertiesSet(){
        this.initDataSouce();
    }

}
