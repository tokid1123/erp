package com.tokid.base.config.mybatis;

import com.tokid.base.customUtils.YamlLoadUtil;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertySource;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/*
* @Description:  MyBatis扫描接口
* @author king
* @date 2017/11/17 16:49
*/
@Configuration
// 注意，由于MapperScannerConfigurer执行的比较早，所以必须有下面的注解,貌似这个注解不生效
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {

        //LOGGER.debug("扫描 Mybatis 配置");
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        PropertySource propertySource = YamlLoadUtil.getYamlLoad("classpath:application.yml");

        mapperScannerConfigurer.setBasePackage(propertySource.getProperty("mybatis.basePackage").toString());
        Properties properties = new Properties();
        properties.setProperty("mappers", propertySource.getProperty("mybatis.mappers").toString());
        properties.setProperty("IDENTITY", propertySource.getProperty("mybatis.identity").toString());
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }

}
