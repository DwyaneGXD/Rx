package com.oasis.rx.core.service;

import io.vavr.control.Option;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

import static io.vavr.API.Option;

@AllArgsConstructor
public class RedisService
{
  private final JSONService         jsonService;
  private final StringRedisTemplate redisTemplate;

  public Option<String> get(final String k)
  {
    return Option(redisTemplate.opsForValue().get(k));
  }

  public <T> Option<T> get(final String k, final Class<T> t)
  {
    return get(k).map(d -> jsonService.toData(d, t));
  }

  /**
   * 默认存60分钟
   */
  public <T> void put(final String k, final T v)
  {
    put(k, v, TimeUnit.MINUTES.toSeconds(60));
  }

  /**
   * 单位分钟
   */
  public <T> void put(final String k, final T v, final long expire)
  {
    redisTemplate.opsForValue().set(k, jsonService.toString(v), expire, TimeUnit.SECONDS);
  }


  public long ttl(final String k)
  {
    return redisTemplate.execute((RedisConnection c) -> c.ttl(k.getBytes(), TimeUnit.MILLISECONDS));
  }

  public void delete(final String k)
  {
    redisTemplate.delete(k);
  }

  public boolean exists(final String k)
  {
    return redisTemplate.execute((RedisConnection c) -> c.exists(k.getBytes()));
  }

  public long increment(final String k)
  {
    return redisTemplate.opsForValue().increment(k, 1);
  }
}
