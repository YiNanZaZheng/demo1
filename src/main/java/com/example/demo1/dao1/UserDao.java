package com.example.demo1.dao1;

import com.example.demo1.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
@Qualifier("db2SqlSessionTemplate")
public interface UserDao {
    /*
     *  通过名字查询用户信息
     */
    @Select("select * from user where name=#{name}")
    User findUserByName(@Param("name") String name);

    @Select("select * from user")
    List<User> findAllUser();

    /*
     *  插入用户信息
     */
    @Insert("insert into user(name,age,money) values(#{name},#{age},#{money})")
    void insertUser(@Param("name") String name,@Param("age") int age, @Param("money") double money);

    /*
     *  根据ID更新用户信息
     */
    @Update("update user set name=#{name},age=#{age},money=#{money} where id=#{id}")
    void updateUser(@Param("name") String name,@Param("age") int age,@Param("money") double money,@Param("id")int id);

    /**
     *  根据id删除用户信息
     */
    @Delete("delete from user where id=#{id}")
    void deleteUser(@Param("id")int id);
}