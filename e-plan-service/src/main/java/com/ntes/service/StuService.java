package com.ntes.service;

import com.ntes.pojo.Student;

import java.util.List;

public interface StuService {
    public List<Student> queryStudents();
    public void addStudent(Student student);
    public void updateStudent(Student student);
    public void delStudent(String sno);
}
