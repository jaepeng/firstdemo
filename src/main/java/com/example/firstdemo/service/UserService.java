package com.example.firstdemo.service;

import com.example.firstdemo.entity.User;
import com.example.firstdemo.repository.UserRepository;
import com.example.firstdemo.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public Iterable<User> getAllUsers()
    {
        return repository.findAll();
    }

    public User findByName(String name)
    {
        return repository.findByAccount(name);
    }

    public boolean add(User user)
    {

        if (findByName(user.getAccount()) != null) {
            return false;
        }
        try {
            User save = repository.save(user);

            System.out.println(user.toString());
            if (save!=null&&!save.getAccount().equals("")){
                return true;
            }else {
                return false;
            }
        }catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }


    }

    public boolean modifyPsw(String name,String newpwd)
    {
        User user = findByName(name);
        if (user!=null){
            user.setId(user.getId());
            newpwd=MD5Utils.encode2hex(newpwd);
            user.setPassword(newpwd);
            repository.save(user);
            return true;
        }
        return false;
    }
    public boolean modifyCover(String account,String coverpath){
        User user = findByName(account);
        if (user!=null){
            user.setId(user.getId());
            user.setHead_cover(coverpath);
            repository.save(user);
            return true;
        }
        return false;
    }

    public String getHeaderCover(String username){
        System.out.println("cover:"+findByName(username).getHead_cover());
        return findByName(username).getHead_cover();
    }
    public boolean deleteByName(String name)
    {
        return repository.deleteByName(name) != 0;
    }

    public User login(String username,String password){
        User user = repository.loginUser(username, password);
        return user;
    }

    /**
     * 所有已注册人名称
     * @return
     */
    public Iterable<String> findAllName(){
        Iterable<String> allName = repository.findAllName();
        return allName;
    }



}
