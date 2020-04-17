package com.example.demo1.dao;

import com.example.demo1.entity.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
@Qualifier("db1SqlSessionTemplate")
public interface BookRepository{
    Book findOnlyBookById(Long id);

    @Select("select b from Book b where b.description = #{description}")
    List<Book> findByDescriptionCustome(@Param("description") String description);

    @Insert("insert into book(name,description) values(#{name},#{description})")
    void save(@Param("name") String name,@Param("description") String description);

    @Delete("delete from book where id=${id}")
    void deleteById(@Param("id") long id);

    @Select("select * from book")
    List<Book> findAll();
}
