package cuz.gpa.controller;

import com.google.gson.Gson;
import cuz.gpa.mapper.CourseMapper;
import cuz.gpa.model.Course;
import cuz.gpa.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseMapper courseMapper;

    private Gson gson=new Gson();
    @GetMapping("/course")
    public String getCourseList(){
        List<Course> courseList=courseMapper.selectList(null);
        return gson.toJson(courseList);
    }
}
