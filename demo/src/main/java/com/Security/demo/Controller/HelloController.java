package com.Security.demo.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("hello")
    public String greet(HttpSession session){
        System.out.println(session.getId());
        return "Hi guys!";
    }
    @GetMapping("/")
    public String hello(HttpServletRequest session){
        System.out.println(session.getSession().getId());
        return "Hello from home page \n Session id: "+session.getSession().getId();
    }
}
