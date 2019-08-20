package com.imooc.service;

import com.imooc.dao.CourseDaoImpl;
import com.imooc.entity.Course;
import com.imooc.entity.CourseList;
import com.imooc.entity.CourseMap;
import com.imooc.entity.CourseSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class DataBindController {

    @Autowired
    private CourseDaoImpl courseDao;

    // @ResponseBody 这个注解作用是：直接将业务方法的返回值相应给客户端，而不跳转jsp页面
    @RequestMapping("/baseType")
    @ResponseBody
    public String baseType(@RequestParam(value = "id") int id) {
        return "id:" + id;
    }

    @RequestMapping("/packageType")
    @ResponseBody
    public String packageType(@RequestParam(value = "id") Integer id) {
        return "id:" + id;
    }

    @RequestMapping("/arrayType")
    @ResponseBody
    public String arrayType(@RequestParam(value = "name")String[] arr) {
        StringBuffer sb = new StringBuffer();
        for (String item : arr) {
            sb.append(item).append(" ");
        }
        return sb.toString();
    }

    @RequestMapping("/pojoType")
    public ModelAndView pojoType(Course course) {
        courseDao.insert(course);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("courses", courseDao.selectAll());
        return modelAndView;
    }

    @RequestMapping("/listType")
    public ModelAndView listType(CourseList courseList) {
        for (Course course : courseList.getCourses()) {
            courseDao.insert(course);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("courses", courseDao.selectAll());
        return modelAndView;
    }

    @RequestMapping("/mapType")
    public ModelAndView mapType(CourseMap courseMap) {
        for (String key : courseMap.getCourses().keySet()) {
            courseDao.insert(courseMap.getCourses().get(key));
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("courses", courseDao.selectAll());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/setType")
    public ModelAndView setType(CourseSet courseSet) {
        for (Course course : courseSet.getCourses()) {
            courseDao.insert(course);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("courses", courseDao.selectAll());
        return modelAndView;
    }

}
