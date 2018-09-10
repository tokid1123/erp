package com.tokid.dynamic;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.tokid.base.config.mybatis.MyBatisConfig;
import com.tokid.base.config.mybatis.MyBatisMapperScannerConfig;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置多数据源
 * @author king
 */
@Configuration
public class DynamicDataSourceConfig {


    @Bean
    @ConfigurationProperties("spring.datasource.druid.first")
    public DataSource firstDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource firstDataSource) {
        DynamicDataSource.datasourcePoolMap.put("first",firstDataSource);
        return new DynamicDataSource(firstDataSource, DynamicDataSource.datasourcePoolMap);
    }
}
