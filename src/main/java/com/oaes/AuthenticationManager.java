package com.oaes;

import com.oaes.entity.Student;
import com.oaes.service.AuthenticationService;
import com.oaes.service.StudentService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AuthenticationManager {
    private AuthenticationService authenticationService;
    private StudentService studentService;
    private static AuthenticationManager instance;

    private AuthenticationManager(){
        authenticationService = new AuthenticationService();
        studentService = new StudentService();
    }

    public static AuthenticationManager getInstance(){
        if (instance == null){
            synchronized(AuthenticationManager.class){
                if (instance == null) instance = new AuthenticationManager();
            }
        }
        return instance;
    }

    public void authenticate() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter login details... \nChoose login method: 1) StudentID 2) Email");
        int response = Integer.parseInt(br.readLine());
        Student student = null;
        String password = "";
        if(response==1){
            System.out.print("Enter student id: ");
            long studentId = Integer.parseInt(br.readLine());
            System.out.print("Enter password: ");
            password = br.readLine();
            if(password.length()==0){
                System.out.println("Exception: Please enter all the details");
                return;
            }
            else{
                try {
                    student = studentService.getStudentById(studentId);
                }
                catch (Exception e) {
                    System.out.println(e);
                    return;
                }
            }
        }
        else if(response==2){
            System.out.print("Enter Email: ");
            String email = br.readLine();
            System.out.print("Enter password: ");
            password = br.readLine();
            if(email.length()==0 || password.length()==0){
                System.out.println("Exception: Please enter all the details");
                return;
            }
            else {
                try {
                    student = studentService.getStudentByEmail(email);
                }
                catch (Exception e) {
                    System.out.println(e);
                    return;
                }
            }
        }
        else System.out.println("Invalid response!");
        if(student==null){
            System.out.println("Invalid ID!");
            return;
        }
        boolean valid = authenticationService.authenticate(student, password);
        if(!valid) return;
        System.out.println("Successfully authenticated....\nRedirecting to Examination interface....");
        System.out.print("Do you accept the terms and conditions? (y/n): ");
        String op = br.readLine();
        if(op.equals("n")){
            System.out.println("You cannot continue without accepting the terms and conditions of the exam.");
            return;
        }
        System.out.print("Please provide webcam and microphone access.. (y/n): ");
        op = br.readLine();
        if(op.equals("n")){
            System.out.println("Webcam and microphone access is mandatory to continue with the exam.");
            return;
        }
        int permissions = 1;
        if(permissions==0){
            System.out.println("Failed to access webcam and microphone! Please try refreshing the page or changing your browser.");
            return;
        }
        System.out.println("Please wait while the exam coordinator starts your test.");
        while(true){
            if(studentService.getStudentById(student.getStudentID()).getTestStatus()==1) break;
        }
        System.out.println("Exam started! Redirecting to Questions....");
        student.setTestStatus(0);
        studentService.updateStudent(student);
    }
}

