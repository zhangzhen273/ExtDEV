package com.ext.sys;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class SysServiceApplication {

    private static Log logger = LogFactory.getLog(SysServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SysServiceApplication.class, args);
        logger.info("SysServiceApplication start up !");
    }
}
