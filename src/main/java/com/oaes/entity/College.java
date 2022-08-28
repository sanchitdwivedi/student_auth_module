package com.oaes.entity;

import javax.persistence.*;

@Entity
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uuid;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String domain;
    @Column(nullable = false)
    private String address;

    public College(String name, String domain, String address) {
        this.name = name;
        this.domain = domain;
        this.address = address;
    }

    public College() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "College{" +
                "name='" + name + '\'' +
                ", domain='" + domain + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

