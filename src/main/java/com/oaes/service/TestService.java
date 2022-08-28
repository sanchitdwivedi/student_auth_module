package com.oaes.service;

import com.oaes.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class TestService {
    private boolean testStarted;
    private List<Student> students;

    public TestService(){
        this.testStarted = false;
        this.students = new ArrayList<>();
    }

    public void addObserver(Student student){
        this.students.add(student);
    }

    public void startTest(){
        this.testStarted = true;
        for(Student student: this.students){
            student.setTestStatus(1);
        }
    }
}
