package com.example.firstdemo.repository;

import com.example.firstdemo.constans.Constans;
import com.example.firstdemo.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    @Query(value = "select * from "+ Constans.TABLE_USER +" where "+TableConstans.USER_ACCOUNT+" = ?1",nativeQuery = true)
    public User findByAccount(String name);

    @Modifying
    @Query(value = "delete from "+ Constans.TABLE_USER +" where "+TableConstans.USER_ACCOUNT+" = ?1",nativeQuery = true)
    public int deleteByName(String name);

    @Query(value = "select * from "+ Constans.TABLE_USER +" where "+TableConstans.USER_ACCOUNT+" = ?1 and "+TableConstans.USER_PASSWORD+"=?2",nativeQuery = true)
    public User loginUser(String account,String password);
}