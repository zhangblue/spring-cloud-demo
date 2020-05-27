Eureka注册中心。用于提供eureka服务


## 开启Eureka服务端

### 添加注入标签
```java
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
```

### 设置Eureka为单机方式
```yaml
eureka:
  instance:
    hostname: 172.16.36.123 # 运行的服务器地址
  client:
    register-with-eureka: false # false表示不想注册中心注册自己
    fetch-registry: false # false表示自己端就是注册中心，我的职责就是维护服务实例，并不需要去检索服务
    service-url:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/ # 设置与Eureka Server交互的地址查询服务和注册服务都需要依赖这个地址
```

### 设置Eureka为集群模式
```yaml
eureka:
  instance:
    hostname: 172.16.36.123 # 运行的服务器地址
  client:
    register-with-eureka: false # false表示不想注册中心注册自己
    fetch-registry: false # false表示自己端就是注册中心，我的职责就是维护服务实例，并不需要去检索服务
    service-url:
      defaultZone: http://eureka7002.com:7002/eureka/ # 当eureka为集群模式时，此内容为除自己以外的其他eureka服务地址
```