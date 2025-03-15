package com.bs.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringController {

    // 방법 1: @RequestMapping 사용
    @RequestMapping("/")
    public String handleSpring() {
        return "index"; // "WEB-INF/views/springpage.jsp"로 연결됩니다
    }

    // 또는 방법 2: @GetMapping 사용 (Spring 4.3+)
    /*
    @GetMapping("/spring")
    public String handleSpring() {
        return "springpage";
    }
    */
}