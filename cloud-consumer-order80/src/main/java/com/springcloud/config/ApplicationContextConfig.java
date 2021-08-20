package com.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lenovo
 * @description
 * @date 2021/7/16 15:30
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced
    //注解可以开启resttemplate的负载均衡功能
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
