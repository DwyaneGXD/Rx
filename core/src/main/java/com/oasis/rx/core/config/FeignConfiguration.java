package com.oasis.rx.core.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

/**
 * Feign配置
 */
@Configuration
public class FeignConfiguration
{
  /**
   * 给每次Feign调用加上JWT
   * @return
   */
  @Bean
  public RequestInterceptor oauth2FeignRequestInterceptor()
  {
    return new RequestInterceptor()
    {
      @Override
      public void apply(RequestTemplate requestTemplate)
      {
        val authentication = SecurityContextHolder.getContext().getAuthentication();
        val details        = (OAuth2AuthenticationDetails) authentication.getDetails();

        requestTemplate.header(HttpHeaders.AUTHORIZATION, "Bearer " + details.getTokenValue());
      }
    };
  }
}
