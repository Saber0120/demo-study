package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sheng on 2018/10/26.
 */
@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello(String name) {
        return "Hello " + name;
    }
}
