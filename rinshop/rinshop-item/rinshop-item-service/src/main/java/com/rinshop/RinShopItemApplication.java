package com.rinshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @program: rinshop
 * @description:
 * @author: Silince
 * @create: 2020-07-19 13:17
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.rinshop.item.mapper")
public class RinShopItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(RinShopItemApplication.class);
    }
}
