package com.spacex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication()
@MapperScan(basePackages = "com.spacex.mapper")
// 扫描所有包以及相关组件包
 @ComponentScan(value={"com.spacex","org.n3r.idworker"})
public class Application {
    public static void main(String args[]){
        try{
        SpringApplication.run(Application.class,args);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
