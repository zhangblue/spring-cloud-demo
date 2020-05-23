package com.zhangd.springcloud.controller;

import com.zhangd.springcloud.entities.CommonResult;
import com.zhangd.springcloud.entities.Payment;
import com.zhangd.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangd
 */
@RestController
@RequestMapping("/payment/")
@Slf4j
public class PaymentController {

  @Autowired
  private PaymentService paymentService;


  @RequestMapping(value = "/create",method = RequestMethod.POST)
  public CommonResult<Payment> create(@RequestBody Payment payment) {

    log.info(payment.getSerial());
    int count = paymentService.create(payment);

    if (count > 0) {
      return new CommonResult<Payment>(200, "insert success", payment);
    } else {
      return new CommonResult<Payment>(444, "insert error");
    }
  }

  @RequestMapping(value = "/get", method = RequestMethod.GET)
  public CommonResult<Payment> getPaymentById(@RequestParam(value = "id") Long id) {
    Payment paymentById = paymentService.getPaymentById(id);

    if (null != paymentById) {
      return new CommonResult<Payment>(200, "get success", paymentById);
    } else {
      return new CommonResult<Payment>(444, "get error");
    }
  }
}
