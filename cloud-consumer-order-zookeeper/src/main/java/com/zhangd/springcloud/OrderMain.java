package com.zhangd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhangd
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain {

  public static void main(String[] args) {
    SpringApplication.run(OrderMain.class, args);
  }
}
