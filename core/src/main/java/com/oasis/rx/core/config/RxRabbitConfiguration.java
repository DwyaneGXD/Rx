package com.oasis.rx.core.config;

import com.oasis.rx.core.properties.RxRabbitProperties;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Rabbit配置
 */
@Configuration
@AllArgsConstructor
@EnableConfigurationProperties(RxRabbitProperties.class)
public class RxRabbitConfiguration
{
  private final RxRabbitProperties properties;

  /**
   * 广播交换机
   */
  @Bean
  public FanoutExchange fanoutExchange()
  {
    return new FanoutExchange(properties.getExchange(), true, false);
  }

  /**
   * 队列
   */
  @Bean
  public Queue queue()
  {
    return QueueBuilder.durable(properties.getQueue()).build();
  }

  /**
   * 队列绑定
   */
  @Bean
  public Binding queueBinding(final Queue queue, final FanoutExchange exchange)
  {
    return BindingBuilder.bind(queue).to(exchange);
  }
}
