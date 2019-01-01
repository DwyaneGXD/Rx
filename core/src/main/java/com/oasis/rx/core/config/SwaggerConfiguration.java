package com.oasis.rx.core.config;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import io.vavr.API;
import io.vavr.collection.List;
import io.vavr.collection.Seq;
import io.vavr.control.Option;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.concurrent.CompletableFuture;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration
{
  @Bean
  public Docket api()
  {
    return new Docket(DocumentationType.SWAGGER_2)
             .select()
             .apis(RequestHandlerSelectors.basePackage("com.oasis.rx"))
             .build()
             .apiInfo(apiInfo())
             .pathMapping("/")
             .consumes(Sets.newHashSet(MediaType.APPLICATION_JSON_UTF8_VALUE))
             .produces(Sets.newHashSet(MediaType.APPLICATION_JSON_UTF8_VALUE))
             .genericModelSubstitutes(ResponseEntity.class,CompletableFuture.class, Seq.class, List.class, Option.class)
             .useDefaultResponseMessages(false)
             .globalResponseMessage(RequestMethod.GET, responseMessages())
             .globalResponseMessage(RequestMethod.POST, responseMessages())
             .globalResponseMessage(RequestMethod.PUT, responseMessages())
             .globalResponseMessage(RequestMethod.DELETE, responseMessages())
             .enableUrlTemplating(true)
             .securitySchemes(Lists.newArrayList(apiKey()))
            .forCodeGeneration(true);
  }

  @Bean
  public SecurityConfiguration security()
  {
    return new SecurityConfiguration("oasis_web", "oasis_web", "oasis_realm", "rx", "", ApiKeyVehicle.HEADER,
                                      HttpHeaders.AUTHORIZATION, "*");
  }

  private java.util.List<ResponseMessage> responseMessages()
  {
    val ok           = new ResponseMessageBuilder().code(200).message("返回数据").build();
    val created      = new ResponseMessageBuilder().code(201).message("资源创建成功").build();
    val noContent    = new ResponseMessageBuilder().code(204).message("删除成功").build();
    val badRequest   = new ResponseMessageBuilder().code(400).message("接口参数错误").build();
    val unauthorized = new ResponseMessageBuilder().code(401).message("无访问权限").build();
    val forbidden    = new ResponseMessageBuilder().code(403).message("禁止访问").build();
    val notFound     = new ResponseMessageBuilder().code(404).message("资源不存在").build();
    val serverError  = new ResponseMessageBuilder().code(500).message("服务器错误").build();
    val badGateway   = new ResponseMessageBuilder().code(502).message("网关错误").build();

    return API.Seq(ok, created, noContent, badRequest, unauthorized, forbidden, notFound, serverError, badGateway).asJava();
  }

  private ApiInfo apiInfo()
  {
    return new ApiInfoBuilder()
             .title("门诊处方")
             .description("门诊处方项目")
             .version("V1")
             .contact(new Contact("后台", "http://60.205.106.190:3000/ryze/Rx", "chengyin.liu@oasismedical.cn"))
             .build();
  }



  private ApiKey apiKey()
  {
    return new ApiKey(HttpHeaders.AUTHORIZATION, HttpHeaders.AUTHORIZATION, "header");
  }
}
