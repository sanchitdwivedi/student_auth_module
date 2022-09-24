package com.oaes.dao;

import com.oaes.entity.Student;

import java.util.regex.Pattern;

public class StudentDaoProxy implements StudentDao{
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private StudentDao studentDao;

    public StudentDaoProxy(){
        studentDao = new StudentDaoImpl();
    }

    @Override
    public Student findByUserId(long studentId) throws Exception {
        if(studentId<0) throw new Exception("Please enter a valid student id");
        return studentDao.findByUserId(studentId);
    }

    @Override
    public Student findByEmail(String email) throws Exception {
        if(!VALID_EMAIL_ADDRESS_REGEX.matcher(email).find()) throw new Exception("Invalid Email exception");
        return studentDao.findByEmail(email);
    }

    @Override
    public void save(Student student) throws Exception {
        if(student==null) throw new Exception("Invalid student exception");
        studentDao.save(student);
    }
}
