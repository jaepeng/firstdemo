package com.example.firstdemo.controller;

import com.example.firstdemo.entity.TicketHistory;
import com.example.firstdemo.entity.User;
import com.example.firstdemo.service.TicketHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/ticketHistory")
public class TicketHistoryController {
    @Autowired
    private TicketHistoryService ticketService;

    /**
     * 查找当前用户所有的历史记录
     * @return
     */
    @PostMapping(path = "/findAll")
    public @ResponseBody Iterable<TicketHistory> findByName(String username){
        return ticketService.getAllTicketHistory(username);
    }
    /**
     * 添加一个领券记录
     * @param ticketHistory
     * @return
     */
    @PostMapping(path = "/add")
    public @ResponseBody boolean add(@RequestBody TicketHistory ticketHistory)
    {
        return ticketService.add(ticketHistory);
    }


}
