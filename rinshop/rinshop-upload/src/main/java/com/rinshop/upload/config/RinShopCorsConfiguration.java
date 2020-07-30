package com.rinshop.upload.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @program: rinshop
 * @description:
 * @author: Silince
 * @create: 2020-07-19 21:28
 **/
@Configuration
public class RinShopCorsConfiguration {
    @Bean
    public CorsFilter corsFilter(){
        //初始化cors配置对象
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 允许跨域的域名，如果要携带cookie，不能写*(代表所有的域名都可以跨域访问)
//        corsConfiguration.addAllowedOrigin("http://localhost:9001/");
        corsConfiguration.addAllowedOrigin("http://manage.rinshop.com");
        corsConfiguration.setAllowCredentials(true); // 允许携带cookie

        //3) 允许的请求方式
        corsConfiguration.addAllowedMethod("OPTIONS");
        corsConfiguration.addAllowedMethod("HEAD");
        corsConfiguration.addAllowedMethod("GET");
        corsConfiguration.addAllowedMethod("PUT");
        corsConfiguration.addAllowedMethod("POST");
        corsConfiguration.addAllowedMethod("DELETE");
        corsConfiguration.addAllowedMethod("PATCH");

        corsConfiguration.addAllowedHeader("*"); // 允许携带任何头信息
        // 初始化cors配置源对象
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        // 返回corsFilter实例，参数：cors配置源对象
        return new CorsFilter(corsConfigurationSource);
    }

}
