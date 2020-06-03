package com.zhangd.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhangd
 */
@Configuration
public class ApplicationContextConfig {

  @Bean
  @LoadBalanced //添加负载均衡访问标签
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }
}
