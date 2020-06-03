package com.zhangd.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
  public static final String INVOKE_URL = "http://cloud-provider-payment";

  @Autowired
  private RestTemplate restTemplate;


  @RequestMapping(method = RequestMethod.GET, value = "/consumer/payment/zk")
  public String getPayment() {
    String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
    return result;
  }
}
