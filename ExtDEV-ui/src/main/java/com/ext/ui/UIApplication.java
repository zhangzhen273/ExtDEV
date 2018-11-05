package com.ext.ui;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UIApplication {

    private static Log logger = LogFactory.getLog(UIApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(UIApplication.class, args);
        logger.info("ヾ(◍°∇°◍)ﾉﾞ    UIApplication 启动成功      ヾ(◍°∇°◍)ﾉﾞ");
    }
}
