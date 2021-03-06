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

    /**
     * 通过用户名寻找用户
     * @param username
     * @return
     */
    @GetMapping(path = "/findByName")
    public @ResponseBody User findByName(String username){
        return userService.findByName(username);
    }

    /**
     * 修改头像链接
     * @param account
     * @param coverpath
     * @return
     */
    @PostMapping(path = "/changeCover")
    public @ResponseBody boolean modifyCover(String account,String coverpath){
        return userService.modifyCover(account,coverpath);
    }

    /**
     * 账户密码登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping(path = "/login")
    public @ResponseBody User login(String username,String password){
        return userService.login(username,password);
    }

    /**
     * 修改密码
     * @param username
     * @param newpsw
     * @return
     */
    @GetMapping(path = "/changePsw")
    public @ResponseBody boolean changePsw(String username,String newpsw){
        return userService.modifyPsw(username,newpsw);
    }

}
