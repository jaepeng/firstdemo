package com.example.firstdemo.repository;

import com.example.firstdemo.constans.Constans;
import com.example.firstdemo.constans.TableConstans;
import com.example.firstdemo.entity.BrowsingHistroy;
import com.example.firstdemo.entity.TicketHistory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BrowsingHistoryRespository extends CrudRepository<BrowsingHistroy,Integer> {
    //通过用户查找历史记录
    @Query(value = "select * from "+ Constans.TABLE_BROWSING_HISTORY +" where "+ TableConstans.BROWSING_USERACCOUNT+"=?1",nativeQuery = true)
    public List<BrowsingHistroy> findByAccount(String account);




}
