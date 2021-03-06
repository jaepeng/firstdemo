package com.example.firstdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 浏览历史记录bean
 */

@Entity
public class BrowsingHistroy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String content;
    String useraccount;
    String cover;

    public BrowsingHistroy(Integer id, String content, String useraccount, String cover) {
        this.id = id;
        this.content = content;
        this.useraccount = useraccount;
        this.cover = cover;
    }

    public BrowsingHistroy(String content, String useraccount, String cover) {
        this.content = content;
        this.useraccount = useraccount;
        this.cover = cover;
    }

    public BrowsingHistroy() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
