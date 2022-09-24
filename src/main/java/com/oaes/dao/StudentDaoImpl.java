package com.oaes.dao;

import com.oaes.entity.Student;
import com.oaes.util.SessionUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class StudentDaoImpl implements StudentDao{
    @Override
    public Student findByUserId(long studentId) {
        Session session = SessionUtil.getSession();
        Criteria criteria = session.createCriteria(Student.class);
        criteria.add(Restrictions.eq("userID", studentId));
        Student student = (Student) criteria.uniqueResult();
        session.close();
        return student;
    }

    @Override
    public Student findByEmail(String email) {
        Session session = SessionUtil.getSession();
        Criteria criteria = session.createCriteria(Student.class);
        criteria.add(Restrictions.eq("email", email));
        Student student = (Student) criteria.uniqueResult();
        session.close();
        return student;
    }

    @Override
    public void save(Student student) {
        Session session = SessionUtil.getSession();
        try {
            Transaction tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Student.class);
            criteria.add(Restrictions.eq("studentID", student.getUserID()));
            Student student1 = (Student) criteria.uniqueResult();
            tx.commit();
            student.setUserID(student1.getUserID());
            session.clear();
            session.beginTransaction();
            session.update(student);
            tx.commit();
        } catch (HibernateException he) {
            System.err.println("Hibernate Exception FOUND!! ->  " + he);
        }

        session.close();
    }
}
