package com.demo.aspect.anno;

import java.lang.annotation.*;

/**
 * Created by sheng on 2018/9/3.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    String value() default "";
}
