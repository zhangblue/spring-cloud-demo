package com.zhangd.springcloud.controller;


import com.alibaba.fastjson.JSONObject;
import com.zhangd.springcloud.entities.CommonResult;
import com.zhangd.springcloud.entities.Payment;
import com.zhangd.springcloud.service.PaymentService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangd
 */
@RestController
@RequestMapping("/payment/")
@Slf4j
public class PaymentController {

  @Autowired
  private PaymentService paymentService;

  @Autowired
  private DiscoveryClient discoveryClient;


  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public CommonResult<Payment> create(@RequestBody Payment payment) {

    log.info(payment.getSerial());
    int count = paymentService.create(payment);

    if (count > 0) {
      return new CommonResult<Payment>(200, "insert success", payment);
    } else {
      return new CommonResult<Payment>(444, "insert error");
    }
  }

  @RequestMapping(value = "/get", method = RequestMethod.GET)
  public CommonResult<Payment> getPaymentById(@RequestParam(value = "id") Long id) {
    Payment paymentById = paymentService.getPaymentById(id);

    if (null != paymentById) {
      return new CommonResult<Payment>(200, "get success", paymentById);
    } else {
      return new CommonResult<Payment>(444, "get error");
    }
  }

  /**
   * 服务发现
   *
   * @return
   */
  @RequestMapping(value = "/discovery", method = RequestMethod.GET)
  public Object discovery() {

    /**
     *
     */
    List<String> services = discoveryClient.getServices();
    for (String service : services) {
      log.info("Application = [{}]", service);
    }

    /**
     * 根据实例id获取所有服务名称
     */
    List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
    for (ServiceInstance instance : instances) {
      log.info("Instance = [{}]", JSONObject.toJSONString(instance));
    }

    return this.discoveryClient;
  }
}
