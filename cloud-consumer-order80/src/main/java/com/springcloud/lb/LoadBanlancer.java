package com.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author lenovo
 * @description
 * @date 2021/8/13 17:52
 */
public interface LoadBanlancer{

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

    
}
