package com.zhangd.springcloud.service;

import com.zhangd.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhangd
 */
public interface PaymentService {

  public int create(Payment payment);

  public Payment getPaymentById(@Param("id") Long id);
}
