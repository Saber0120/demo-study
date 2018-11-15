package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sheng on 2018/10/26.
 */
@Controller
public class JspController {

    @GetMapping("/toHello")
    public ModelAndView toHello(String name) {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("name", name + "fffgggsss");
        return mv;
    }
}
