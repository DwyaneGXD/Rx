package com.oasis.rx.core.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.oasis.rx.core.service.JSONService;
import com.oasis.rx.core.service.SecurityService;
import com.oasis.rx.core.tool.DateTool;
import io.vavr.jackson.datatype.VavrModule;
import lombok.val;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

@Configuration
@ImportAutoConfiguration(classes = {SwaggerConfiguration.class})
public class ServerConfiguration
{
  @Bean
  public ObjectMapper objectMapper()
  {
    val mapper = new ObjectMapper();
    //Vavr模型
    mapper.registerModule(new VavrModule());
    //忽略实体没有的字段
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    //驼峰转下划线
    mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    //格式化输出
    mapper.enable(SerializationFeature.INDENT_OUTPUT);
    //禁用日期时间戳
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    //不输出null,"",空字段
    mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    //日期格式化
    val format = new SimpleDateFormat(DateTool.FULLDATE);
    format.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
    mapper.setDateFormat(format);

    return mapper;
  }

  @Bean
  public HttpMessageConverters fastJsonHttpMessageConverters(final ObjectMapper mapper)
  {
    return new HttpMessageConverters(new MappingJackson2HttpMessageConverter(mapper));
  }

  @Bean
  public JSONService jsonService(final ObjectMapper mapper)
  {
    return new JSONService(mapper);
  }

  @Bean
  public SecurityService securityService(final JSONService jsonService)
  {
    return new SecurityService(jsonService);
  }
}

