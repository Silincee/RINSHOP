package com.rinshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: rinshop
 * @description:
 * @author: Silince
 * @create: 2020-07-19 12:31
 **/
@SpringBootApplication
@EnableEurekaServer
public class RinShopRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(RinShopRegistryApplication.class);
    }
}
