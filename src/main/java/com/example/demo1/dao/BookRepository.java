package com.example.demo1.dao;

import com.example.demo1.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {
    Book findOnlyBookById(Long id);

    @Query("select b from Book b where b.description = :description")
    List<Book> findByDescriptionCustome(@Param("description") String description);

}
