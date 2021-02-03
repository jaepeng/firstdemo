package com.example.firstdemo.service;

import com.example.firstdemo.entity.TicketHistory;
import com.example.firstdemo.entity.User;
import com.example.firstdemo.repository.TicketHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Transactional
@Service
public class TicketHistoryService {
    @Autowired
    TicketHistoryRepository repository;
    public Iterable<TicketHistory> getAllTicketHistory(String account){
        List<TicketHistory> allTicket = repository.findByAccount(account);
        //最后添加的反而是第一
        Collections.reverse(allTicket);
        return allTicket;
    }
    public Iterable<TicketHistory> getTicketHistoryByTime(String account,String time){
        return repository.findByTime(account,time);
    }

    public boolean add(TicketHistory ticketHistory)
    {

        //如果这个添加的优惠券已经是第一个,则不会再添加
        String content = ticketHistory.getContent();
        String useraccount = ticketHistory.getUseraccount();
        //这个列表已经被翻转了
        ArrayList<TicketHistory> allTicketHistory = (ArrayList<TicketHistory>) getAllTicketHistory(ticketHistory.getUseraccount());
        if (allTicketHistory.get(0).getContent().equals(ticketHistory.getContent())) {
            return false;
        }

        try {
            TicketHistory save = repository.save(ticketHistory);

            if (save!=null&&!save.getContent().equals("")){
                return true;
            }else {
                return false;
            }
        }catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }


    }

}
