package com.example.firstdemo.repository;

import com.example.firstdemo.constans.Constans;
import com.example.firstdemo.constans.TableConstans;
import com.example.firstdemo.entity.TicketHistory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketHistoryRepository extends CrudRepository<TicketHistory,String> {
    @Query(value = "select * from "+ Constans.TABLE_TICKET_HISTORY +" where "+ TableConstans.TICKET_HISTORY_TIME+" = ?1 and useraccount=?2",nativeQuery = true)
    public List<TicketHistory> findByTime(String time,String account);

    @Query(value = "select * from "+Constans.TABLE_TICKET_HISTORY+" where "+TableConstans.TICKET_HISTORY_USERACCOUNT+"=?1",nativeQuery = true)
    public List<TicketHistory>findByAccount(String account);

    @Query(value = "select * from "+ Constans.TABLE_TICKET_HISTORY +" where "+TableConstans.TICKET_HISTORY_CONTENT+" = ?1 and "+TableConstans.TICKET_HISTORY_USERACCOUNT+"=?2",nativeQuery = true)
    public List<TicketHistory> findByContent(String content,String account);

    @Query(value = "select * from "+Constans.TABLE_TICKET_HISTORY+" where "+TableConstans.TICKET_HISTORY_USERACCOUNT+"=?1 and "+TableConstans.TICKET_HISTORY_CATEGORY+"=?2",nativeQuery = true)
    public List<TicketHistory>findByAccountAndCategory(String account,String category);

    @Query(value = "SELECT category,COUNT(category) FROM ticket_history WHERE useraccount"+"=?1"+" GROUP BY category ",nativeQuery = true)
    public List findCategoryNum(String username);




}
