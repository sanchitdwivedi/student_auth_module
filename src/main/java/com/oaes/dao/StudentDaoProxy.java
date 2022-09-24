package com.oaes.dao;

import com.oaes.entity.Student;

import java.util.regex.Pattern;

public class StudentDaoProxy implements StudentDao{
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private StudentDao studentDao;

    public StudentDaoProxy(){
        studentDao = new StudentDaoImpl();
    }
    
    private boolean validStudentId(long studentId){
        return studentId>=0;
    }

    private boolean validStudent(Student student){
        return student!=null;
    }

    private boolean validEmail(String email){
        return !VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
    }

    @Override
    public Student findByUserId(long studentId) throws Exception {
        if(!validStudentId(studentId)) throw new Exception("Please enter a valid student id");
        return studentDao.findByUserId(studentId);
    }

    @Override
    public Student findByEmail(String email) throws Exception {
        if(validEmail(email)) throw new Exception("Invalid Email exception");
        return studentDao.findByEmail(email);
    }

    @Override
    public void save(Student student) throws Exception {
        if(!validStudent(student)) throw new Exception("Invalid student exception");
        studentDao.save(student);
    }
}
