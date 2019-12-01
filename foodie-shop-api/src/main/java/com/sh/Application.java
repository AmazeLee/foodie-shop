package com.sh;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 扫描MyBatis使用的通用的包
@MapperScan(basePackages = "com.sh.mapper")
public class Application {

    public static void main(String[] args){

        SpringApplication.run(Application.class,args);
    }
}
