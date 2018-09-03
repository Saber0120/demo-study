package com.demo.swagger.controller;

import io.swagger.annotations.*;
import org.apache.catalina.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sheng on 2018/9/3.
 */
@Api(value = "/test", tags = "测试接口模块")
@RestController
@RequestMapping("/test")
public class TestSwaggerController {

    @ApiOperation(value = "展示首页信息", notes = "展示首页信息notes")
    @GetMapping("/show")
    public Object showInfo() {
        return "hello swagger";
    }

    @ApiOperation(value = "添加用户信息", notes = "添加用户信息notes")
    @ApiImplicitParam(name = "user", value = "User", required = true, dataType = "User")
    @PostMapping("/addUser")
    public Object addUser(@RequestBody User user) {
        return "success";
    }

    @ApiResponses({
        @ApiResponse(code = 200, message = "操作成功", response = Object.class),
        @ApiResponse(code = 500, message = "服务器异常", response = Exception.class)
    })
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "path", name = "id", value = "ID", required = true, dataType = "Long"),
        @ApiImplicitParam(paramType = "query", name = "name", value = "Name", required = true, dataType = "String"),
        @ApiImplicitParam(paramType = "head", name = "age", value = "Age", required = true, dataType = "String"),
        @ApiImplicitParam(paramType = "body", name = "user", value = "User", required = true, dataType = "User"),
        @ApiImplicitParam(paramType = "form", name = "user2", value = "User", required = true, dataType = "User")
    })
    @ApiOperation(value = "测试输入参数", notes = "测试输入参数注解")
    @PostMapping("/param/{id}")
    public Object testApiImplicitParam(HttpServletRequest request,
                                       @PathVariable Long id,
                                       @RequestParam String name,
                                       @RequestBody User user,
                                       User user2) {
        String ageStr = request.getHeader("age");
        if (StringUtils.isNumeric(ageStr)) {
            int age = Integer.valueOf(ageStr);
            System.out.println("age ----- " + age);
        }
        return "success";
    }
}
