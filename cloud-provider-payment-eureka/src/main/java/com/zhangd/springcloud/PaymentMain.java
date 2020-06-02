package com.zhangd.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhangd
 * @EnableEurekaClient 此标签标示当前程序为Eureka客户端，启动时会将自己注册进Eureka集群
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentMain {

  public static void main(String[] args) {
    SpringApplication.run(PaymentMain.class, args);
  }
}
