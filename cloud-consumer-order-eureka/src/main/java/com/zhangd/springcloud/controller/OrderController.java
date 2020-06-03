package com.zhangd.springcloud.controller;

import com.zhangd.springcloud.entities.CommonResult;
import com.zhangd.springcloud.entities.Payment;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhangd
 */
@RestController
@Slf4j
public class OrderController {

  /**
   * 此处直接设置eureka中的服务名称即可，需要配合RestTemplate中的@LoadBalanced标签使用
   */
  public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
//  public static final String PAYMENT_URL = "http://172.16.12.23:8001";

  @Autowired
  private RestTemplate restTemplate;

  @RequestMapping(method = RequestMethod.POST, value = "/consumer/payment/create")
  public CommonResult<Payment> create(@RequestBody Payment payment) {
    return restTemplate
        .postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/consumer/payment/get")
  public CommonResult<Payment> getPayment(@RequestParam(value = "id") Long id) {
    Map<String, String> mapRequest = new HashMap<>(1);
    mapRequest.put("id", id.toString());

    return restTemplate
        .getForObject(PAYMENT_URL + "/payment/get?id={id}", CommonResult.class, mapRequest);
  }
}
