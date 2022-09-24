package com.oaes.dao;

import com.oaes.entity.Student;

public interface StudentDao {
    public Student findByUserId(long studentId) throws Exception;
    public Student findByEmail(String email) throws Exception;
    public void save(Student student) throws Exception;
}
