package com.zhangd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @EnableEurekaServer 标签表示当前程序为Eureka服务端。
 *
 * @author di.zhang
 * @date 2020/5/23
 * @time 22:06
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain {

  public static void main(String[] args) {
    SpringApplication.run(EurekaMain.class, args);
  }
}
