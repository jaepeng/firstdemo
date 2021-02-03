package com.example.firstdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String account;
    private String password;
    private String head_cover;

    public User() {
    }

    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public User(String account, String password, String head_cover) {
        this.account = account;
        this.password = password;
        this.head_cover = head_cover;
    }

    public User(Integer id, String account, String password, String head_cover) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.head_cover = head_cover;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHead_cover() {
        return head_cover;
    }

    public void setHead_cover(String headCover) {
        this.head_cover = headCover;
    }
}
