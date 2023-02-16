package org.treasure.chest.dev.template.controller;

import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.treasure.chest.dev.template.vo.StudentParam;
import org.treasure.chest.dev.template.vo.TeacherParam;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

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

    @PostMapping("/teacher")
    public void fileAndFiled(HttpServletResponse resp, TeacherParam params){
        System.out.println("打印参数----------");
        String name = params.getName();

//        List<MultipartFile> photoList = params.getPhotoList();

        System.out.println("-----------------");

    }

    @PostMapping("/teacher2")
    public void fileAndFiled2(@RequestPart("") TeacherParam params, @RequestPart("") MultipartFile photo){
        System.out.println("打印参数----------");
        String name = params.getName();

//        List<MultipartFile> photoList = params.getPhotoList();

        System.out.println("-----------------");

    }
}
