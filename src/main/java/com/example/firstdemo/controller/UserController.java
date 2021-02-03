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
public class UserController {
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

    @GetMapping(path = "/findByName")
    public @ResponseBody User findByName(String username){
        return userService.findByName(username);
    }

    @PostMapping(path = "/changeCover")
    public @ResponseBody boolean modifyCover(String account,String coverpath){
        return userService.modifyCover(account,coverpath);
    }

    @PostMapping(path = "/login")
    public @ResponseBody User login(String username,String password){
        return userService.login(username,password);
    }

    @GetMapping(path = "/changePsw")
    public @ResponseBody boolean changePsw(String username,String newpsw){
        return userService.modifyPsw(username,newpsw);
    }

}
