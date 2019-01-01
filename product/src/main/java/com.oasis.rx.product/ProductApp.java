package com.oasis.rx.product;

import com.github.pagehelper.PageHelper;
import com.oasis.rx.core.config.ServerConfiguration;
import com.oasis.rx.core.config.SwaggerConfiguration;
import lombok.AllArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

/**
 * Created by SY on 2017/11/29.
 */
@AllArgsConstructor
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
//MyBatisDao层位置
@ImportAutoConfiguration(value = {SwaggerConfiguration.class, ServerConfiguration.class})
@MapperScan("com.oasis.rx.product.dao")
public class ProductApp {
    public static void main(String[] args) {
        SpringApplication.run(ProductApp.class, args);
    }

    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("dialect", "mysql");    //配置mysql数据库的方言
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}







