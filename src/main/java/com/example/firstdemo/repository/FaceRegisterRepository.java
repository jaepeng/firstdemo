package com.example.firstdemo.repository;

import com.example.firstdemo.constans.Constans;
import com.example.firstdemo.constans.TableConstans;
import com.example.firstdemo.entity.FaceRegisterInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 人脸注册数据
 */
public interface FaceRegisterRepository extends CrudRepository<FaceRegisterInfo,Integer> {



    /**
     * 通过name找faceInfo
     */
    @Query(value = "select * from "+ Constans.TABLE_FACE_REGISTER_INFO +" where "+ TableConstans.FACE_REGISTER_NAME+" = ?1",nativeQuery = true)
    public List<FaceRegisterInfo> findByName(String name);

    /**
     * 寻找所有已注册名字
     * @return
     */
    @Query(value = "select "+TableConstans.FACE_REGISTER_NAME+" from "+ Constans.TABLE_FACE_REGISTER_INFO,nativeQuery = true)
    public List<String> finAllName();

    /**
     * 通过名字删除用户人脸信息
     */
    @Modifying
    @Query(value = "delete from "+ Constans.TABLE_FACE_REGISTER_INFO +" where "+TableConstans.FACE_REGISTER_NAME+" = ?1",nativeQuery = true)
    public int deleteByName(String name);


}
