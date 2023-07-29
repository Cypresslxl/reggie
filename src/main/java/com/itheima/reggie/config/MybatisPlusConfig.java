package com.itheima.reggie.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置MP的分页插件
 */
@Configuration
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }
}
//Sure! This code is a configuration class for MyBatis Plus (MP) that sets up and enables the pagination feature for MyBatis Plus in a Spring Boot application.
//
//        Let's break down the code step by step:
//
//        1. `@Configuration`: This is a Spring stereotype annotation that marks the class as a configuration class. It indicates that this class provides bean definitions and configuration settings.
//
//        2. `public class MybatisPlusConfig`: This is the configuration class for MyBatis Plus.
//
//        3. `@Bean`: This is a Spring annotation used to define a bean (object) that will be managed by the Spring container.
//
//        4. `public MybatisPlusInterceptor mybatisPlusInterceptor()`: This method defines a bean of type `MybatisPlusInterceptor`, which is the main interceptor for MyBatis Plus. It is responsible for intercepting and handling various MyBatis Plus features.
//
//        5. `MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();`: This line creates a new instance of `MybatisPlusInterceptor`.
//
//        6. `mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());`: This line adds an inner interceptor to the `MybatisPlusInterceptor`. In this case, the inner interceptor is the `PaginationInnerInterceptor`, which provides the pagination functionality for MyBatis Plus.
//
//        7. `return mybatisPlusInterceptor;`: This line returns the configured `MybatisPlusInterceptor` bean.
//
//        The purpose of this configuration is to enable pagination for MyBatis Plus in your Spring Boot application. By creating a `MybatisPlusInterceptor` bean and adding the `PaginationInnerInterceptor` as an inner interceptor, you activate the pagination feature in MyBatis Plus. The `PaginationInnerInterceptor` will intercept any database queries that require pagination and automatically append the necessary SQL statements to enable pagination.
//
//        With this configuration in place, you can use MyBatis Plus's built-in pagination support in your application's data access layer without having to write complex pagination queries manually. The pagination feature will handle limit and offset clauses in the SQL queries transparently, making it easier to fetch data in chunks for display in the frontend or for other purposes that require paginated data.