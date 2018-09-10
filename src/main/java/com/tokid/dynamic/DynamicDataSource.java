package com.tokid.dynamic;

import com.alibaba.druid.pool.DruidDataSource;
import com.tokid.base.utils.MapUtils;
import com.tokid.base.utils.StringUtils;
import com.tokid.model.CDataSource;
import org.apache.ibatis.datasource.DataSourceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ZHAOTING001 on 2017/2/23.
 */

public class DynamicDataSource extends AbstractRoutingDataSource {

    Logger logger = LoggerFactory.getLogger(DynamicDataSource.class);

//    @Autowired
//    private CDataSourceService cDataSourceService;

    public static final Map<Object, Object> datasourcePoolMap = new HashMap<>();

    public DynamicDataSource(DataSource defaultTargetDataSource) {
        Map<Object, Object> map = MapUtils.newHashMap();
        map.put("first",defaultTargetDataSource);
        super.setTargetDataSources(map);
    }

    protected Object determineCurrentLookupKey() {
        logger.info("database changed to:{}",DataSourceContextHolder.getDataSourceName());
        String key = DataSourceContextHolder.getDataSourceName();
        if(StringUtils.isBlank(key)){
            key = "first";
        }
        return key;
    }

    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

//    public void initDataSouce(){
//        logger.info("-------------->开始初始化加载创建动态数据源...");
//        //获取所有数据源配置信息
//        List<CDataSource> dataSourceList = cDataSourceService.selectAll();
//        for(CDataSource cDataSource : dataSourceList) {
//            //
//            DruidDataSource DruidDataSource = new DruidDataSource();
//            try {
//                DruidDataSource.setDriverClassName(cDataSource.getDriverClassName());
//                DruidDataSource.setUrl(cDataSource.getUrl());
//                DruidDataSource.setUsername(cDataSource.getUsername());
//                DruidDataSource.setPassword(cDataSource.getPassword());
//                //
//                DruidDataSource.setInitialSize(cDataSource.getInitialSize());
//                DruidDataSource.setMinIdle(cDataSource.getMinIdle());
//                DruidDataSource.setMaxActive(cDataSource.getMaxActive());
//
//            } catch (DataSourceException e) {
//                e.printStackTrace();
//            }
//            datasourcePoolMap.put(cDataSource.getDbName(), DruidDataSource);
//
//        }
//        this.setTargetDataSources(datasourcePoolMap);
//        logger.info("-------------->初始化加载创建动态数据源完毕，加载数："+datasourcePoolMap.size());
//    }

    public void addDatasource(CDataSource cDataSource){
        boolean isDataSourcExist = datasourcePoolMap.containsKey(cDataSource.getDbName());
        DruidDataSource druidDataSource = new DruidDataSource();
        if (!isDataSourcExist) {
            try {
//            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//            dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/" + dbName);
//            dataSource.setUrl("jdbc:sqlserver://" + url);
                druidDataSource.setDriverClassName(cDataSource.getDriverClassName());
                druidDataSource.setUrl(cDataSource.getUrl());
                druidDataSource.setUsername(cDataSource.getUsername());
                druidDataSource.setPassword(cDataSource.getPassword());
            } catch (DataSourceException e) {
                e.printStackTrace();
            }
            datasourcePoolMap.put(cDataSource.getDbName(), druidDataSource);
            this.setTargetDataSources(datasourcePoolMap);
//        DataSourceContextHolder.setDataSourceType(dbName);
            logger.info("-------------->动态添加数据源，数据源数："+datasourcePoolMap.size());
        }
    }

}
