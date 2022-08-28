package com.oaes.entity;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uuid;

    @Column(nullable = false, unique = true)
    private long studentID;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String rollNo;
    @Column(nullable = false, unique = true)
    private String email;
    @ManyToOne
    private College college;
    @Column(nullable = false)
    private int locked;
    @Column(nullable = false)
    private int triesLeft;
    @Column(nullable = false)
    private int testStatus;

    public Student(long uuid, long studentID, String password, String rollNo, String email, College college, int locked, int triesLeft) {
        this.uuid = uuid;
        this.studentID = studentID;
        this.password = password;
        this.rollNo = rollNo;
        this.email = email;
        this.college = college;
        this.locked = locked;
        this.triesLeft = triesLeft;
        this.testStatus = 0;
    }

    public Student() {

    }

    public int getTestStatus() {
        return testStatus;
    }

    public void setTestStatus(int testStatus) {
        this.testStatus = testStatus;
    }

    public long getUuid() {
        return uuid;
    }

    public void setUuid(long uuid) {
        this.uuid = uuid;
    }

    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }

    public int getTriesLeft() {
        return triesLeft;
    }

    public void setTriesLeft(int triesLeft) {
        this.triesLeft = triesLeft;
    }

    @Override
    public String toString() {
        return "Student{" +
                "uuid=" + uuid +
                ", studentID=" + studentID +
                ", password='" + password + '\'' +
                ", rollNo='" + rollNo + '\'' +
                ", email='" + email + '\'' +
                ", college=" + college +
                ", locked=" + locked +
                ", triesLeft=" + triesLeft +
                ", testStatus=" + testStatus +
                '}';
    }
}
