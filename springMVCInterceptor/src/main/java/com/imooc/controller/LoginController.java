package com.imooc.controller;

import com.imooc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/logined")
    public String logined(@RequestParam("account") String account,@RequestParam("password") String password, HttpSession session) {
        User user = new User();
        if (account.equals("cmy") && password.equals("123456")) {
            user.setAccount(account);
            user.setPassword(password);
            session.setAttribute("session_user", user);
            return "redirect:user/search";
        } else {
            return "login";
        }
    }
}
