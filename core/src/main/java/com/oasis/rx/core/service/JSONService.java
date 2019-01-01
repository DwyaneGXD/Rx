package com.oasis.rx.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * JSON基础服务
 */
@Slf4j
@AllArgsConstructor
public class JSONService
{
  private final ObjectMapper mapper;

  public <T> T toData(final String json, final Class<T> clazz)
  {
    try
    {
      return mapper.readValue(json, clazz);
    }
    catch (IOException e)
    {
      e.printStackTrace();
      log.error(e.getMessage());
      return null;
    }
  }

  public String toString(final Object data)
  {
    try
    {
      return mapper.writeValueAsString(data);
    }
    catch (JsonProcessingException e)
    {
      e.printStackTrace();
      log.error(e.getMessage());
      return null;
    }
  }
}
