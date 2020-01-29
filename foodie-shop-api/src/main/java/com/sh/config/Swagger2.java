package com.sh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName Swagger2
 * @Desc
 * @Author leeshuhua
 * @Date 2020/1/29 15:30
 * @Version V1.0
 **/
@Configuration
@EnableSwagger2
public class Swagger2 {


    // 配置Swagger2核心配置 docket
    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)  // 指定Api类型为swagger2
                .apiInfo(apiInfo())                 // 用于定义Api文档汇总信息
                .select().apis(RequestHandlerSelectors.basePackage("com.sh.controller"))  // 指定Controller包
                .paths(PathSelectors.any())         // 所有Controller
                .build();
    }


    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("天天吃货 电商平台接口Api")      // 文档页标题
                .contact(new Contact("lee",
                        "https://www.sh.com",
                        "leeshuhau@163.com"))   // 联系人信息
                .description("专为天天吃货提供的Api文档")       // 详细信息
                .version("1.0.0")                              // 版本号
                .termsOfServiceUrl("https://www.sh.com")       // 网站地址
                .build();
    }
}
