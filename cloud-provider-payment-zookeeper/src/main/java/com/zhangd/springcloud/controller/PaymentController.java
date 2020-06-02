package com.zhangd.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author di.zhang
 * @date 2020/6/2
 * @time 22:49
 **/
@RestController
@RequestMapping("/payment/")
@Slf4j
public class PaymentController {

  @Value("${server.port}")
  private String serverPort;

  @RequestMapping(value = "/zk", method = RequestMethod.GET)
  public String paymentZk() {
    String result = new JSONObject().fluentPut("server-port", serverPort)
        .fluentPut("uuid", UUID.randomUUID().toString()).toJSONString();
    return result;
  }
}
