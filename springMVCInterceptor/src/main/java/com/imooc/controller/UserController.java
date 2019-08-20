package com.imooc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/search")
    public String search() {
        System.out.println("================2. 第二步执行业务处理器中的search方法");
        return "user/search";
    }

    @RequestMapping("/updatePwd")
    public String updatePwd() {
        System.out.println("================2. 第二步执行业务处理器中的updatePwd方法");
        return "/user/updatePwd";
    }

    @RequestMapping("/updateHeaderPic")
    public String updateHeaderPic() {
        System.out.println("================2. 第二步执行业务处理器中的updateHeaderPic方法");
        return "user/updateHeaderPic";
    }
}
