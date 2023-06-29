package cuz.gpa.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import cuz.gpa.mapper.CourseMapper;
import cuz.gpa.mapper.ScoreMapper;
import cuz.gpa.mapper.StudentMapper;
import cuz.gpa.model.Course;
import cuz.gpa.model.Score;
import cuz.gpa.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GpaController {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private ScoreMapper scoreMapper;

    private Gson gson=new Gson();

    @GetMapping("/gpa")
    public String getGpaList(){
        List<Student> studentList=studentMapper.selectList(null);
        for(Student s : studentList){
            String sid=s.getId();

            QueryWrapper<Score> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("sid",sid);
            List<Score> scoreList=scoreMapper.selectList(queryWrapper);

            double sumPoint=0;
            double sumCredit=0;

            for(Score sc:scoreList){
                String cid=sc.getCid();
                Course c =courseMapper.selectById(cid);
                double credit = c.getCredit();

                double score =sc.getScore();
                double point = score/10-5.0;
                if(score<60){
                    point =0;
                }
                sumPoint+=point*credit;
                sumCredit+=credit;
            }
            double gpa=sumPoint/sumCredit;
            s.setGpa(gpa);
        }
        return gson.toJson(studentList);
    }
}
