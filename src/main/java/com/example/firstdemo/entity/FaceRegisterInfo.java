package com.example.firstdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 人脸注册实体类
 */

@Entity
public class FaceRegisterInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
//    private byte[] featureData;
    private String name;

    public FaceRegisterInfo(String name) {
//        this.featureData = faceFeature;
        this.name = name;
    }


    public FaceRegisterInfo(Integer id, byte[] featureData, String name) {
        this.id = id;
//        this.featureData = featureData;
        this.name = name;
    }

    public FaceRegisterInfo() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
