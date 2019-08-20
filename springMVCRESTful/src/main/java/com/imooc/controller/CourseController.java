package com.imooc.controller;

import com.imooc.dao.CourseDao;
import com.imooc.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CourseController {

    @Autowired
    private CourseDao courseDao;

    @RequestMapping("/beforeAddCourse")
    public ModelAndView beforeAddCourse() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addCourse");
        return modelAndView;
    }

    @RequestMapping("/add")
    public String add(Course course) {
        courseDao.insert(course);
        return "redirect:/getAll";
    }

    @RequestMapping("/getAll")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("courses", courseDao.selectAll());
        modelAndView.setViewName("showCourse");
        return modelAndView;
    }

    @RequestMapping("/getById/{id}")
    public ModelAndView getById(@PathVariable(value = "id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editCourse");
        modelAndView.addObject("course", courseDao.selectById(id));
        return modelAndView;
    }

    @RequestMapping("/update")
    public String update(Course course) {
        courseDao.update(course);
        return "redirect:/getAll";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id")int id) {
        courseDao.delete(id);
        return "redirect:/getAll";
    }
}
