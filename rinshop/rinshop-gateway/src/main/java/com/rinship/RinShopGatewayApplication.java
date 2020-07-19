package com.rinship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @program: rinshop
 * @description:
 * @author: Silince
 * @create: 2020-07-19 12:56
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class RinShopGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(RinShopGatewayApplication.class);
    }
}
