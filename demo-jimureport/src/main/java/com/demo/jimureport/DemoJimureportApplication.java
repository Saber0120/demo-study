package com.demo.jimureport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.jeecg.modules.jmreport","com.demo.jimureport"})
public class DemoJimureportApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoJimureportApplication.class, args);
    }

}
