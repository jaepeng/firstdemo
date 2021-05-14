package com.example.firstdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TicketHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String content;//淘口令做主键
    String useraccount;
    String coverpath;
    String title;
    String category;//目录类别
    String time;


    public TicketHistory(Integer id, String content, String useraccount, String coverpath, String title, String time,String category) {
        this.id = id;
        this.content = content;
        this.useraccount = useraccount;
        this.coverpath = coverpath;
        this.title = title;
        this.time = time;
        this.category=category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public TicketHistory() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public TicketHistory(String content, String useraccount, String coverpath, String title, String time) {
        this.content = content;
        this.useraccount = useraccount;
        this.coverpath = coverpath;
        this.title = title;
        this.time = time;
    }

    public TicketHistory(String coverpath, String title, String content) {
        this.coverpath = coverpath;
        this.title = title;
        this.content = content;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount;
    }

    public String getCoverpath() {
        return coverpath;
    }

    public void setCoverpath(String coverpath) {
        this.coverpath = coverpath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TicketHistory{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", useraccount='" + useraccount + '\'' +
                ", coverpath='" + coverpath + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
