package com.imooc.handler;

import com.imooc.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @RequestMapping("/addProduct")
    public ModelAndView addProduct(Product product) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", product);
        modelAndView.setViewName("show1");
        return modelAndView;
    }

}
