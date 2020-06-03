# 访问客户端，提供用户直接访问，并且将消息转发至后面的payment模块

## 服务注册
`@EnableEurekaClient` 标签表示此工程为Eureka的客户端。程序启动时会想eureka中进行注册


## Eureka配置
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

## 设置在Eureka中注册的名称
```yaml
spring:
  application:
    name: cloud-order-service # 设置工程名称。工程会已这个名字注册进eureka中
```

## eureka负载均衡
程序使用`org.springframework.web.client.RestTemplate`类进行http请求发送，在注入时需要使用`@LoadBalanced`标签标记使用负载均衡，默认的负载均衡方式为轮循

```java
@Configuration
public class ApplicationContextConfig {

  @Bean
  @LoadBalanced //添加负载均衡访问标签
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }
}
```

在进行消息转发时，转发的目标地址使用Eureka中的注册Application名称
```java
  @RestController
  @Slf4j
  public class OrderController {
  
    /**
     * 此处直接设置eureka中的服务名称即可，需要配合RestTemplate中的@LoadBalanced标签使用
     */
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
  //  public static final String PAYMENT_URL = "http://172.16.12.23:8001";
  
    @Autowired
    private RestTemplate restTemplate;
  
    @RequestMapping(method = RequestMethod.POST, value = "/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
      return restTemplate
          .postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }
  
    @RequestMapping(method = RequestMethod.GET, value = "/consumer/payment/get")
    public CommonResult<Payment> getPayment(@RequestParam(value = "id") Long id) {
      Map<String, String> mapRequest = new HashMap<>(1);
      mapRequest.put("id", id.toString());
  
      return restTemplate
          .getForObject(PAYMENT_URL + "/payment/get?id={id}", CommonResult.class, mapRequest);
    }
  }
```