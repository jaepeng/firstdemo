package com.example.firstdemo.service;


import com.example.firstdemo.entity.FaceRegisterInfo;
import com.example.firstdemo.repository.FaceRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.TextUtils;

import java.util.List;

@Transactional
@Service
public class FaceRegiterInfoService {
    @Autowired
    FaceRegisterRepository registerRepository;

    /**
     * 返回全部人脸信息给与比对
     * @return
     */
    public Iterable<FaceRegisterInfo> getAllFaceInfo(){
        return registerRepository.findAll();
    }

    /**
     * 添加一个人脸信息
     * @param
     * @return
     */
    public boolean add(FaceRegisterInfo faceRegisterInfo){
        List<String> names = registerRepository.finAllName();
        if (names.contains(faceRegisterInfo.getName())){
            //如果该用户名已经人脸注册则返回false
            return false;
        }
        FaceRegisterInfo save = registerRepository.save(faceRegisterInfo);
        return true;
    }
    //将所有人脸信息添加到数据库
    public boolean addAll(Iterable<FaceRegisterInfo> allFaceRegisters){
        if (allFaceRegisters==null){
            return false;
        }
        registerRepository.saveAll(allFaceRegisters);
        return true;
    }

    /**
     * 通过名字来找数据列表
     * @param name
     * @return
     */
    public List<FaceRegisterInfo> findByName(String name){
        System.out.println(name);
        if (name.isEmpty()){
            return null;
        }
        return registerRepository.findByName(name);

    }

    /**
     * 找到所有人脸注册用户名
     * @return
     */

    public List<String> findAllName(){
        return registerRepository.finAllName();
    }

    public void deleteAllFaceRegister(){
        System.out.println("清除所有人脸数据");
        registerRepository.deleteAll();
    }


    public int deleteFaceRegisterByName(String name)
    {

        int count = registerRepository.deleteByName(name);
        System.out.println(count);
        return count;
    }





}
