package com.oasis.rx.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Rabbit配置
 */
@Data
@ConfigurationProperties("rx.rabbit")
public class RxRabbitProperties
{
  //队列名
  private String queue;
  //延迟队列名
  private String delayQueue    = "dead.letter.queue";
  //延迟交换机名
  private String delayExchange = "";
  //广播交换机名
  private String exchange      = "Rx.EventBus";
}
