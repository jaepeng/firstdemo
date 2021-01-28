package com.example.firstdemo.controller;

import com.example.firstdemo.entity.User;
import com.example.firstdemo.repository.UserRepository;
import com.example.firstdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/firstdemo")
public class MainController {
    @Autowired
    private UserService userService;

    /**
     * 查找所有用户
     * @return
     */
    @GetMapping(path = "/getAll")
    public @ResponseBody Iterable<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    /**
     * 添加一个用户
     * @param user
     * @return
     */
    @PostMapping(path = "/add")
    public @ResponseBody boolean add(@RequestBody User user)
    {
        return userService.add(user);
    }

    @PostMapping(path = "/findByName")
    public @ResponseBody List<User> findByName(String username){
        return userService.findByName(username);
    }

}
