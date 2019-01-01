package com.oasis.rx.product;

import com.oasis.rx.core.config.ServerConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by SY on 2017/11/29.
 */
@SpringBootApplication
//MyBatisDao层位置
@ImportAutoConfiguration(value = {ServerConfiguration.class})
@MapperScan("com.oasis.rx.product.dao")
public class ProductApp {
  public static void main(String[] args) {
    SpringApplication.run(ProductApp.class, args);
  }
}







