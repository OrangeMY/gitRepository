package com.imooc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class AnnotationHandler {

    // 书写自己的业务方法，同时ModelAndView作为返回值
    @RequestMapping("/test1")
    public ModelAndView modelAndViewTest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","Jack");
        modelAndView.setViewName("show");
        return modelAndView;
    }

    // 第二种，String作为view返回值，Model作为传入的参数
    @RequestMapping("/test2")
    public String modelTest(Model model) {
        model.addAttribute("name", "Rose");
        return "show";
    }

    //第三种，String作为View的返回值，Map作为传入的参数，类似第二种方法
    @RequestMapping("/test3")
    public String mapTest(Map<String, String> map) {
        map.put("name", "Amy");
        return "show";
    }

}
