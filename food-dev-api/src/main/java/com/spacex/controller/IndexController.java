package com.spacex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ApiIgnore  //当前类的api接口不会显示在swagger页面
@RestController
public class HelloWorld {

    @GetMapping("/hello")
    public Object Hello(){
        return "Hello world";
    }


    //设置Session帮助进一步了解
    @GetMapping("/getSession")
    public Object setSession(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.setAttribute("userInfo","new User");
         //超时时间
        session.setMaxInactiveInterval(5000);
        //从session中取出
        session.getAttribute("userInfo");
        return "ok";
    }

}
