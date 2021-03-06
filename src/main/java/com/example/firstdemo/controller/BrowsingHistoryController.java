package com.example.firstdemo.controller;

import com.example.firstdemo.entity.BrowsingHistroy;
import com.example.firstdemo.service.BrowsingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/browsingHistory")
public class BrowsingHistoryController {
    @Autowired
    private BrowsingHistoryService browserService;

    @GetMapping("/getAllHistory")
    public @ResponseBody Iterable<BrowsingHistroy> getAllHistory(String useraccount){
        System.out.println("Controller.name:" + useraccount);
        return browserService.getAllHistory(useraccount);
    }
    @PostMapping("/add")
    public @ResponseBody boolean addHistory(@RequestBody BrowsingHistroy browsingHistroy){
        return browserService.add(browsingHistroy);
    }


}
