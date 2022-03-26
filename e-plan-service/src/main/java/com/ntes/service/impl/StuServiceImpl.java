package com.ntes.service.impl;

import com.ntes.mapper.StudentMapper;
import com.ntes.pojo.Student;
import com.ntes.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StudentMapper stuMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Student> queryStudents() {
        List<Student> students = stuMapper.selectAll();
        return students;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addStudent(Student student) {
        stuMapper.insert(student);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateStudent(Student student) {
        stuMapper.updateByPrimaryKey(student);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void delStudent(String sno) {
        stuMapper.deleteByPrimaryKey(sno);
    }
}
