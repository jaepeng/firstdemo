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
    @Query(value = "select * from "+ Constans.TABLE_USER +" where name = ?1",nativeQuery = true)
    public List<User> findByName(String name);

    @Modifying
    @Query(value = "delete from "+ Constans.TABLE_USER +" where name = ?1",nativeQuery = true)
    public int deleteByName(String name);
}