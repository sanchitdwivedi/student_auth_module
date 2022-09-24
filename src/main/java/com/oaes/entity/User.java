package com.oaes.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uuid;

    @Column(nullable = false, unique = true)
    private long userID;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String email;

    public User() {
    }

    public User(long uuid, long userID, String password, String email) {
        this.uuid = uuid;
        this.userID = userID;
        this.password = password;
        this.email = email;
    }

    public long getUuid() {
        return uuid;
    }

    public void setUuid(long uuid) {
        this.uuid = uuid;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid=" + uuid +
                ", userID=" + userID +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
