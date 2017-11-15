package com.tokid;/*
* @Description: TODO
* @author king
* @date 2017/11/14 17:03
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ServletComponentScan
public class ManageApplication {

        public static void main(String[] args) {
            SpringApplication.run(ManageApplication.class, args);
    }
}
