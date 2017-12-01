package com.tokid.base.config.mybatis;

import com.tokid.base.customUtils.YamlLoadUtil;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertySource;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.xml.bind.PropertyException;
import java.util.Properties;

/*
* @Description:  MyBatis扫描接口
* @author king
* @date 2017/11/17 16:49
*/
@Configuration
// 注意，由于MapperScannerConfigurer执行的比较早，所以必须有下面的注解
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {

        //LOGGER.debug("扫描 Mybatis 配置");
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        try {
            PropertySource propertySource = YamlLoadUtil.getYamlLoad("classpath:application.yml");

            if (propertySource.getProperty("mybatis.config.basePackage").toString() == null) {
                throw new PropertyException("缺少 application.yml: mybatis.config.basePackage 属性");
            }
            if (propertySource.getProperty("mybatis.config.mappers").toString() == null) {
                throw new PropertyException("缺少 application.yml: mybatis.config.mappers 属性");
            }
            if (propertySource.getProperty("mybatis.config.identity") == null) {
                throw new PropertyException("缺少 application.yml: mybatis.config.identity 属性");
            }
            mapperScannerConfigurer.setBasePackage(propertySource.getProperty("mybatis.config.basePackage").toString());
            Properties properties = new Properties();
            properties.setProperty("mappers", propertySource.getProperty("mybatis.config.mappers").toString());
            properties.setProperty("IDENTITY", propertySource.getProperty("mybatis.config.identity").toString());
            mapperScannerConfigurer.setProperties(properties);
        } catch (PropertyException e) {
            e.printStackTrace();
        }
        return mapperScannerConfigurer;
    }

}
