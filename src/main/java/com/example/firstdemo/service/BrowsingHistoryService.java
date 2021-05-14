package com.example.firstdemo.service;

import com.example.firstdemo.entity.BrowsingHistroy;
import com.example.firstdemo.repository.BrowsingHistoryRespository;
import com.example.firstdemo.utils.NLPTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.TextUtils;

import java.util.*;

@Transactional
@Service
public class BrowsingHistoryService {
    @Autowired
    BrowsingHistoryRespository respository;
    private StringBuilder stringBuilder;

    /**
     * 根据用户名返回搜索历史记录
     */
    public List<BrowsingHistroy> getAllHistory(String name){
        System.out.println("browsingHistory name:"+name);
        return respository.findByAccount(name);
    }
    public boolean add(BrowsingHistroy browsingHistroy){
        //不为空则代表存入成功
        return respository.save(browsingHistroy)!=null;
    }

    public  List<String> getHotWord(){
        List<String> allSearch = respository.findAllSearch();
        List<String> hotSearch = new ArrayList<>();
        if (null!=allSearch&&!allSearch.isEmpty()){
            stringBuilder = new StringBuilder();
            for (String search : allSearch) {
                stringBuilder.append(search+",");
            }
            hotSearch= NLPTools.wordFrequency(stringBuilder.toString());
        }
        return hotSearch;
    }
}
