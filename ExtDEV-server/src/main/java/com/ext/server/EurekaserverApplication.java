package com.ext.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaserverApplication {

    private static Log logger = LogFactory.getLog(EurekaserverApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EurekaserverApplication.class, args);
        logger.info("EurekaserverApplication start up !");
    }

}
