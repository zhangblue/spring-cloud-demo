package com.zhangd.springcloud.service.impl;

import com.zhangd.springcloud.dao.PaymentDao;
import com.zhangd.springcloud.entities.Payment;
import com.zhangd.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangd
 */
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

  @Autowired
  private PaymentDao paymentDao;


  @Override
  public int create(Payment payment) {
    return paymentDao.create(payment);
  }

  @Override
  public Payment getPaymentById(Long id) {
    return paymentDao.getPaymentById(id);
  }
}
