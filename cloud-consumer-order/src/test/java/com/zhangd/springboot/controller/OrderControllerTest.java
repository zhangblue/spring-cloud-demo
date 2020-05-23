package com.zhangd.springboot.controller;

import com.zhangd.springcloud.entities.CommonResult;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class OrderControllerTest {

  public static final String PAYMENT_URL = "http://localhost:8001";

  @Test
  public void test() {
    RestTemplate restTemplate = new RestTemplate();
    Map<String, Long> mapRequest = new HashMap<>(1);
    mapRequest.put("id", 1L);
    restTemplate
        .getForEntity("http://localhost:8001/payment/get?id={id}", CommonResult.class, mapRequest);
  }

}
