package com.rinshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: rinshop
 * @description:
 * @author: Silince
 * @create: 2020-07-29 20:59
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class RinShopUploadApplication {
    public static void main(String[] args) {
        SpringApplication.run(RinShopUploadApplication.class);
    }
}
