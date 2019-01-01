package com.oasis.rx.core.config;

import com.oasis.rx.core.service.APPService;
import com.oasis.rx.core.service.JSONService;
import com.oasis.rx.core.service.RedisService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.client.RestTemplate;

/**
 * 用APP接口时引入
 */
@Configuration
@AllArgsConstructor
public class APPConfiguration
{
  private final JSONService jsonService;

  @Bean
  public RedisService redisService(final JSONService jsonService, final StringRedisTemplate redisTemplate)
  {
    return new RedisService(jsonService, redisTemplate);
  }

  @Bean
  public APPService appService(final RedisService redisService, final RestTemplate restTemplate)
  {
    return new APPService(redisService, restTemplate);
  }
}
