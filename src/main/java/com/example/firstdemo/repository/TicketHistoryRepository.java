package com.example.firstdemo.repository;

import com.example.firstdemo.constans.Constans;
import com.example.firstdemo.entity.TicketHistory;
import com.example.firstdemo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketHistoryRepository extends CrudRepository<TicketHistory,String> {
    @Query(value = "select * from "+ Constans.TABLE_TICKET_HISTORY +" where time = ?1 and useraccount=?2",nativeQuery = true)
    public List<TicketHistory> findByTime(String time,String account);

    @Query(value = "select * from "+Constans.TABLE_TICKET_HISTORY+" where useraccount=?1",nativeQuery = true)
    public List<TicketHistory>findByAccount(String account);

    @Query(value = "select * from "+ Constans.TABLE_TICKET_HISTORY +" where content = ?1 and useraccount=?2",nativeQuery = true)
    public List<TicketHistory> findByContent(String content,String account);


}
