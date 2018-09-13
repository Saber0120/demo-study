package com.demo.aspect.controller;

import com.demo.aspect.anno.SysLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sheng on 2018/9/3.
 */
@RestController
@RequestMapping("/sys")
public class SysController {

    @GetMapping("/log1")
    @SysLog(value = "log1")
    public void log1() {

    }

    @GetMapping("/log2")
    @SysLog(value = "log2")
    public Integer log2() {

        return 123;
    }

    @GetMapping("/log3")
    @SysLog(value = "log3")
    public String log3() {

        return "log3";
    }

    @GetMapping("/log4")
    @SysLog(value = "log4")
    public int log4(int age) {
       if (age < 0) {
           throw new IllegalArgumentException("年龄不能小于0");
       }
       return age;
    }

    @GetMapping("/log5")
    @SysLog(value = "log5")
    public String log5() {
        System.out.println("log5执行");
        return "Log5";
    }
}
