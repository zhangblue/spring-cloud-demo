访问服务端，用于接收cloud-consumer-order的访问，查询数据库。

启动时将自己注册入Eureka中

## 服务注册
`@EnableEurekaClient` 标签表示此工程为Eureka的客户端。程序启动时会想eureka中进行注册

## Eureka注册

### 设置Eureka中注册使用的名字
```yaml
spring:
  application:
    name: cloud-order-service # 设置工程名称。工程会已这个名字注册进eureka中
```

### 设置Eureka地址
```yaml
# eureka 配置
eureka:
  client:
    register-with-eureka: true # 表示是否将自己的注册进EurekaServer 默认为true
    fetch-registry: true # 表示是否从EurekaServer抓取已有的注册信息，默认为true。单节点无所谓，集群必须设置为true才能配合ribbon使用负载均衡
    service-url:
      # defaultZone: http://localhost:7001/eureka # 单机版。填写eureka的服务端地址，必须加/eureka 否则会报错访问不到
      defaultZone: http://172.16.12.23:7001/eureka,http://172.16.12.23:7002/eureka # 集群版
```

### 设置当前程序为Eureka客户端
```java
/**
 * @author zhangd
 * @EnableEurekaClient 此标签标示当前程序为Eureka客户端，启动时会将自己注册进Eureka集群
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain {

  public static void main(String[] args) {
    SpringApplication.run(PaymentMain.class, args);
  }
}
```

