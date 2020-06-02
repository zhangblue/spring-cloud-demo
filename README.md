Spring Cloud 框架搭建 demo

# Eureka
## 遇到的坑

### hosts文件配置错误
此工程在运行时，开启Eureka集群版本，并且通过访问`cloud-consumer-order`模块向`cloud-provider-payment`模块转发消息时，提示错误信息`java.lang.IllegalArgumentException: The character [_] is never valid in a domain name`,原因为我将hosts文件中域名配置为office_elastic导致的，将_替换为-后恢复正常。

eureka 停止更新：https://github.com/Netflix/eureka/wiki

# Zookeeper
1. 使用3.5.6版本
2. 关闭防火墙
