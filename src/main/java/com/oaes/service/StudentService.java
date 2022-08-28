package com.oaes.service;

import com.oaes.dao.StudentDao;
import com.oaes.dao.StudentDaoImpl;
import com.oaes.dao.StudentDaoProxy;
import com.oaes.entity.Student;

public class StudentService {
    private StudentDao studentDao;

    public StudentService(){
        studentDao = new StudentDaoProxy();
    }

    public void updateStudent(Student student) throws Exception {
        studentDao.save(student);
    }

    public Student getStudentById(long studentId) throws Exception {
        return studentDao.findByStudentId(studentId);
    }

    public Student getStudentByEmail(String email) throws Exception {
        return studentDao.findByEmail(email);
    }
}
