package com.oasis.rx.core.service;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.HashMap;

/**
 * 安全基础服务
 */
@AllArgsConstructor
public class SecurityService
{
  private final JSONService jsonService;

  /**
   * 获取本次请求Token
   * @return
   */
  private Jwt getJWT()
  {
    val attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
    val token      = attributes.getRequest().getHeader(HttpHeaders.AUTHORIZATION).substring(7);

    return JwtHelper.decode(token);
  }

  /**
   * 用户来源
   * @return
   */
  public String getSource()
  {
    val data = jsonService.toData(getJWT().getClaims(), HashMap.class);
    return data.get("source").toString();
  }
}
