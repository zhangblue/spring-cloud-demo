package com.zhangd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author di.zhang
 * @date 2020/6/2
 * @time 22:46
 **/
@SpringBootApplication
@EnableDiscoveryClient // 该注解用于向使用consul或者zookeeper作为注册中心时注册服务
public class PaymentZkMain {

  public static void main(String[] args) {
    SpringApplication.run(PaymentZkMain.class, args);
  }
}
