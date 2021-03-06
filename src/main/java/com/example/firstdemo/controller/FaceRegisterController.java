package com.example.firstdemo.controller;

import com.example.firstdemo.entity.FaceRegisterInfo;
import com.example.firstdemo.service.FaceRegiterInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/faceRegister")
public class FaceRegisterController {
    @Autowired
    private FaceRegiterInfoService faceRegiterInfoService;


    @GetMapping("/getAllInfo")
    public @ResponseBody
    Iterable<FaceRegisterInfo> getAllFaceInfo() {
        return faceRegiterInfoService.getAllFaceInfo();
    }

    @GetMapping("/getAllRegisterName")
    public @ResponseBody
    Iterable<String> getAllFaceRegisterName() {
        return faceRegiterInfoService.findAllName();
    }

    /**
     * 添加注册信息
     */
    @PostMapping("/addRegisterInfo")
    public @ResponseBody
    boolean add(@RequestBody FaceRegisterInfo registerInfo) {
        return faceRegiterInfoService.add(registerInfo);
    }

    /**
     * 将所有信息添加到数据据库
     */
    @PostMapping("/addAllRegisterInfo")
    public @ResponseBody
    boolean add(@RequestBody List<FaceRegisterInfo> registerInfos) {
        return faceRegiterInfoService.addAll(registerInfos);
    }

    /**
     * 通过名字查找数据
     */
    @GetMapping("/findByName")
    public @ResponseBody
    List<FaceRegisterInfo> findByName(String name) {
        return faceRegiterInfoService.findByName(name);

    }

    @GetMapping("/deleteAllFaceRegister")
    public @ResponseBody void
    deleteAllName(){
        faceRegiterInfoService.deleteAllFaceRegister();
    }
    @GetMapping("/deleteFaceRegisterByName")
    public @ResponseBody int
    deletByName(String name){
        int count = faceRegiterInfoService.deleteFaceRegisterByName(name);
        if (count!=0){
            return count;
        }
        return 0;
    }
}
