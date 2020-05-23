package com.zhangd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhangd
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderMain {

  public static void main(String[] args) {
    SpringApplication.run(OrderMain.class, args);
  }
}
