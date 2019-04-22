package com.example.demo.model;

import com.example.demo.enums.Status;

import javax.persistence.*;

@Entity
@Table(name= "user_1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullname;
    private String nickname;
    private int age;
    private Status status;
    private Boolean isActive;

    public User() {
    }

    public User(String fullname, String nickname, int age, Status status, Boolean isActive) {
        this.id = id;
        this.fullname = fullname;
        this.nickname = nickname;
        this.age = age;
        this.status = status;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
