package cuz.gpa.controller;

import com.google.gson.Gson;
import cuz.gpa.mapper.StudentMapper;
import cuz.gpa.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentMapper studentMapper;
    private Gson gson=new Gson();
    @GetMapping("/student")
    public String getStudentList(){
        List<Student> studentList=studentMapper.selectList(null);
        return gson.toJson(studentList);
    }

    @GetMapping("/student/{id}")
    public String getStudentById(@PathVariable("id") String id){
        Student s=studentMapper.selectById(id);
        return gson.toJson(s);
    }

    @DeleteMapping("/delstudent")
    public void DeleteMapping(@RequestBody Student student){
        studentMapper.deleteById(student);
    }

    @PostMapping("/addstudent")
    public void AddMapping(@RequestBody Student student) {
        studentMapper.insert(student);
    }

    @PutMapping("/updatestudent")
    public void PutMapping(@RequestBody Student student) {
        studentMapper.updateById(student);
    }
}
