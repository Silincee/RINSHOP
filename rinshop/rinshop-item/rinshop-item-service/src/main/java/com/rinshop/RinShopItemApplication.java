package com.rinshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: rinshop
 * @description:
 * @author: Silince
 * @create: 2020-07-19 13:17
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class RinShopItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(RinShopItemApplication.class);
    }
}
