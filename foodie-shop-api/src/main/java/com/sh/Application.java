package com.sh;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 扫描MyBatis使用的通用的包
@MapperScan(basePackages = "com.sh.mapper")
// 扫描所有包以及相关组件包
@ComponentScan(basePackages = {"com.sh","org.n3r.idworker"})
// 开启定时任务
@EnableScheduling
public class Application {

    public static void main(String[] args){

        SpringApplication.run(Application.class,args);
    }
}
