package com.yang.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lenovo
 * @description
 * @date 2021/8/13 17:17
 */
@Configuration
public class myselfRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
