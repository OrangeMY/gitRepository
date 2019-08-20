package com.imooc.handler;

import com.imooc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping("login")
    public ModelAndView login(User user) {
        ModelAndView modelAndView = new ModelAndView();
        if (user.getUsername() != null && "123456".equals(user.getPassword())) {
            modelAndView.addObject("User", user);
            modelAndView.setViewName("success");
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

}
