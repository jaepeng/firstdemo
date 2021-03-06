package com.example.firstdemo.service;

import com.example.firstdemo.entity.BrowsingHistroy;
import com.example.firstdemo.repository.BrowsingHistoryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BrowsingHistoryService {
    @Autowired
    BrowsingHistoryRespository respository;
    /**
     * 根据用户名返回历史记录
     */
    public List<BrowsingHistroy> getAllHistory(String name){
        System.out.println("browsingHistory name:"+name);
        return respository.findByAccount(name);
    }
    public boolean add(BrowsingHistroy browsingHistroy){
        return respository.save(browsingHistroy)==null;
    }
}
