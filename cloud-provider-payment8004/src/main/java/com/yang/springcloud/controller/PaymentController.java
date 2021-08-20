package com.yang.springcloud.controller;

import com.yang.springcloud.entities.CommonResult;
import com.yang.springcloud.entities.Payment;
import com.yang.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author lenovo
 * @description
 * @date 2021/7/16 14:57
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果" + result);
        if (result > 0){
            return new CommonResult(200,"插入成功, serverPort:" + serverPort, result);
        }else {
            return new CommonResult(444,"插入失败");
        }
    }

    @GetMapping(value = "/payment/get")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("插入结果" + payment);
        if (payment != null){
            return new CommonResult(200,"查询成功, serverPort:" + serverPort, payment);
        }else {
            return new CommonResult(444,"查询失败", null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        //获取eureka里注册过的微服务有哪些
        List<String> services = discoveryClient.getServices();
        services.forEach(element -> {
            log.info("~~~~~~~" + element);
        });
        //这个微服务下有哪几个？
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(serviceInstance -> {
            log.info(serviceInstance.getServiceId() + "\t" + serviceInstance.getHost() +
                    "\t" + serviceInstance.getPort() + "\t" + serviceInstance.getUri());
        });
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/zk")
    public String paymentzk(){
        return "springcloud zookeeper" + serverPort + UUID.randomUUID().toString();
    }
}
