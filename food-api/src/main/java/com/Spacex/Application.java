package com.Spacex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //扫描当前包和当前子包

public class Application {
    public static void main(String args[]){
    SpringApplication.run(Application.class,args);
    }
}
