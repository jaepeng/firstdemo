package com.example.firstdemo.service;

import com.example.firstdemo.entity.TicketHistory;
import com.example.firstdemo.entity.User;
import com.example.firstdemo.repository.TicketHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TicketHistoryService {
    @Autowired
    TicketHistoryRepository repository;
    public Iterable<TicketHistory> getAllTicketHistory(String account){
        return repository.findByAccount(account);
    }
    public Iterable<TicketHistory> getTicketHistoryByTime(String account,String time){
        return repository.findByTime(account,time);
    }

    public boolean add(TicketHistory ticketHistory)
    {

        String content = ticketHistory.getContent();
        String useraccount = ticketHistory.getUseraccount();
        if (repository.findByContent(content,useraccount).size()>0) {
            System.out.println("已经存在了！");
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
