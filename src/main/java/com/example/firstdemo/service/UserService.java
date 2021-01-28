package com.example.firstdemo.service;

import com.example.firstdemo.entity.User;
import com.example.firstdemo.repository.UserRepository;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.TextUtils;

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

    public List<User> findByName(String name)
    {
        return repository.findByName(name);
    }

    public boolean add(User user)
    {

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

    public boolean modify(Integer id,String name)
    {
        User user = new User();
        user.setAccount(name);
        user.setId(id);
        repository.save(user);
        return true;
    }

    public boolean deleteByName(String name)
    {
        return repository.deleteByName(name) != 0;
    }
}
