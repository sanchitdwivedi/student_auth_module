package com.oaes.service;

import com.oaes.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class TestService {
    private boolean testStarted;
    private List<Student> subscribers;

    public TestService(){
        this.testStarted = false;
        this.subscribers = new ArrayList<>();
    }

    public void subscribe(Student student){
        this.subscribers.add(student);
    }

    public void unsubscribe(Student student){
        for(Student s: subscribers){
            if(s.getUuid()==student.getUuid()){
                subscribers.remove(s);
                break;
            }
        }
    }

    public void notifySubscribers(){
        for(Student s: subscribers) s.setTestStatus(1);
    }

    public void startTest(){
        this.testStarted = true;
        for(Student student: this.subscribers){
            student.setTestStatus(1);
        }
    }
}
