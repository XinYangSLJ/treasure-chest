package org.treasure.chest.dev.template.controller;

import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.treasure.chest.dev.template.vo.StudentParam;

import javax.validation.Valid;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2022-05-10 11:10
 */
@RestController
@RequestMapping("/test")
public class MyRestController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World !";
    }

    @GetMapping("/signUp")
    public String signUp(@Valid StudentParam param){

        return "Hello World !";
    }
}
