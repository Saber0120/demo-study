package com.demo.thymeleaf.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sheng on 2018/6/11.
 */
@RequestMapping("/index")
@RestController
public class IndexController {

    @GetMapping("/test")
    public String test() {
        return "123";
    }

    @GetMapping
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("status", 0);
        return mv;
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String username, @RequestParam String password) {
        ModelAndView mv = new ModelAndView("index");
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.equals(username, "admin") && StringUtils.equals(password, "123")) {
            mv.addObject("name", "管理员");
            mv.addObject("status", 1);
        } else {
            mv.addObject("status", 0);
        }
        mv.addObject("user", map);
        return mv;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestParam String username, @RequestParam String password) {
        return ResponseEntity.ok().build();
    }
}
