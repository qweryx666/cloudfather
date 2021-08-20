package com.yang.springcloud.service;

import com.yang.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author lenovo
 * @description
 * @date 2021/7/16 14:53
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
