package com.ntes.controller;

import com.ntes.pojo.Student;
import com.ntes.service.StuService;
import com.ntes.service.impl.StuServiceImpl;
import com.ntes.utils.JSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StuController {
    @Autowired
    private StuService stuService;

    @GetMapping("/query")
    public JSONResult queryStudents(){
        List<Student> students = stuService.queryStudents();
        return JSONResult.ok(students);
    }

    @PostMapping("/add")
    public JSONResult addStudent(@RequestBody Student student){
        stuService.addStudent(student);
        return JSONResult.ok();
    }

    @PostMapping("/update")
    public JSONResult updateStudent(@RequestBody Student student){
        stuService.updateStudent(student);
        return JSONResult.ok();
    }

    @PostMapping("/del")
    public JSONResult delStudent(@RequestParam String sno){
        if(StringUtils.isBlank(sno)){
            return JSONResult.errorMsg("学号不能为空");
        }

        stuService.delStudent(sno);
        return JSONResult.ok();
    }
}
