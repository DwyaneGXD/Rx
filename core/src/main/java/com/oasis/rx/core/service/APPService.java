package com.oasis.rx.core.service;

import com.oasis.rx.core.constant.APPConstant;
import com.oasis.rx.core.constant.RequestField;
import com.oasis.rx.core.service.dto.Result;
import com.oasis.rx.core.service.dto.Token;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.LinkedHashMap;

/**
 * 泓华APP接口
 */
@Slf4j
@AllArgsConstructor
public class APPService
{
  private final RedisService redis;
  private final RestTemplate rest;
//  private final String uri = "https://buz.oasisapp.cn/";
  private final String uri = "https://buztest190.oasisapp.cn/";

  /**
   * Token换类型
   * 优先读缓存
   */
  public Token getToken(String accessToken)
  {
    return redis.get(accessToken, Token.class)
             .getOrElse(() ->
             {
               if (RequestField.TOKEN_VALUE.equals(accessToken)) return defaultToken();
               val result = rest.getForObject(URI.create(uri + "honghclient/userAccount/token/" + accessToken), Result.class);
               val data   = (LinkedHashMap) result.data;
               val token  = new Token((String) data.get("tokenid"), ((Long) data.get("accountid")).toString(), (Integer) data.get("apptype"));
               redis.put(accessToken, token);
               return token;
             });
  }

  public Token defaultToken()
  {
    return new Token(RequestField.TOKEN_VALUE, RequestField.TOKEN_VALUE, APPConstant.APP_USER);
  }
}

