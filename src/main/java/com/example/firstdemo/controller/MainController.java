package com.example.firstdemo.controller;

import com.example.firstdemo.entity.User;
import com.example.firstdemo.repository.UserRepository;
import com.example.firstdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/firstdemo")
public class MainController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/getAll")
    public @ResponseBody Iterable<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @PostMapping(path = "/add")
    public @ResponseBody boolean add(@RequestBody User user)
    {
        return userService.add(user);
    }
}
