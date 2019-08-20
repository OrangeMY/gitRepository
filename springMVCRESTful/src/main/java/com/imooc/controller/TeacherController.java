package com.imooc.controller;

import com.imooc.dao.TeacherDao;
import com.imooc.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeacherController {

    @Autowired
    private TeacherDao teacherDao;

    @RequestMapping("/beforeAddTeacher")
    public ModelAndView beforeAddTeacher() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addTeacher");
        return modelAndView;
    }

    @RequestMapping("/addTeacher")
    public String add(Teacher teacher) {
        teacherDao.insert(teacher);
        return "redirect:/getAllTeacher";
    }

    @RequestMapping("/getByTeacherId/{id}")
    public ModelAndView getByTeacherId(@PathVariable(value = "id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editTeacher");
        modelAndView.addObject("teacher", teacherDao.selectById(id));
        return modelAndView;
    }

    @RequestMapping("/getAllTeacher")
    public ModelAndView getAllTeacher() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("showTeacher");
        modelAndView.addObject("teachers", teacherDao.selectAll());
        return modelAndView;
    }

    @RequestMapping("/updateTeacher")
    public String update(Teacher teacher) {
        teacherDao.update(teacher);
        return "redirect:/getAllTeacher";
    }

    @RequestMapping("/deleteTeacher/{id}")
    public String delete(@PathVariable(value = "id")int id) {
        teacherDao.delete(id);
        return "redirect:/getAllTeacher";
    }
}
