package com.oaes.service;

import com.oaes.entity.Student;

public class AuthenticationService {
    private StudentService studentService;

    public AuthenticationService(){
        studentService = new StudentService();
    }

    public boolean authenticate(Student student, String password) throws Exception {
        if(student.getLocked()==1){
            System.out.println("Exception: The student account is currently locked. Please contact your exam coordinator.");
            return false;
        }
        if(!student.getPassword().equals(password)){
            if(student.getTriesLeft()==1){
                student.setLocked(1);
                student.setTriesLeft(0);
                try {
                    studentService.updateStudent(student);
                } catch(Exception e){
                    System.out.println(e);
                    return false;
                }
                System.out.println("Invalid password. Your account has been locked because of too many wrong attempts. Please contact exam coordinator");
                return false;
            }
            student.setTriesLeft(student.getTriesLeft()-1);
            try {
                studentService.updateStudent(student);
            } catch(Exception e){
                System.out.println(e);
                return false;
            }
            System.out.println("Password is not valid. Please try again. " + student.getTriesLeft() + " attempt(s) left!");
            return false;
        }
        return true;
    }
}
