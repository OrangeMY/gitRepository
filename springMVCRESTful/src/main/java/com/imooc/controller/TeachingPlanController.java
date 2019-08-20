package com.imooc.controller;

import com.imooc.dao.TeacherDao;
import com.imooc.dao.TeachingPlanDao;
import com.imooc.entity.TeachingPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class TeachingPlanController {

    @Autowired
    private TeachingPlanDao teachingPlanDao;
    @Autowired
    private TeacherDao teacherDao;

    @RequestMapping("/beforeAddTeachingPlan")
    public ModelAndView beforeAdd() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("teachers", teacherDao.selectAll());
        modelAndView.setViewName("addTeachingPlan");
        return modelAndView;
    }

    @RequestMapping("/addTeachingPlan")
    public String addTeachingPlan(TeachingPlan teachingPlan) {
        teachingPlan.setAppointTime(new Date());
        // 将教师属性塞入教学计划类中，从而实现 两个类之间的关联关系
        teachingPlan.setTeacher(teacherDao.selectById(teachingPlan.gettId()));
        teachingPlanDao.insert(teachingPlan);
        return "redirect:/getAllTeachingPlan";
    }

    @RequestMapping("/getAllTeachingPlan")
    public ModelAndView getAllTeachingPlan() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("teachingPlans", teachingPlanDao.getAll());
        modelAndView.setViewName("showTeachingPlan");
        return modelAndView;
    }

    @RequestMapping("/getByTeachingPlanId/{id}")
    public ModelAndView getByTeachingPlanId(@PathVariable(value = "id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        // 把所有老师查出来，用于编辑时使用
        modelAndView.addObject("teachers", teacherDao.selectAll());
        modelAndView.addObject("teachingPlan", teachingPlanDao.getById(id));
        modelAndView.setViewName("editTeachingPlan");
        return modelAndView;
    }

    @RequestMapping("/updateTeachingPlan")
    public String update(TeachingPlan teachingPlan) {
        teachingPlan.setTeacher(teacherDao.selectById(teachingPlan.gettId()));
        teachingPlanDao.update(teachingPlan);
        return "redirect:/getAllTeachingPlan";
    }

    @RequestMapping("/deleteTeachingPlan/{id}")
    public String delete(@PathVariable(value = "id") int id) {
        teachingPlanDao.delete(id);
        return "redirect:/getAllTeachingPlan";
    }
}
