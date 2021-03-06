package com.example.demo1.controller;

import com.example.demo1.dao.BookRepository;
import com.example.demo1.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@Validated
public class BookController {

    @Autowired
    BookRepository bookDao;

    public BookController(BookRepository bookDao) {
        this.bookDao = bookDao;
    }

    @PostMapping("/book")
    public ResponseEntity addBook(@RequestBody @Valid Book book) {
        bookDao.save(book.getName(),book.getDescription());
        System.out.println(book);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity deleteBookById(@Valid @PathVariable("id") @Max(value = 5,message = "超过id的范围了")long id) {
        bookDao.deleteById(id);
        return ResponseEntity.ok(bookDao.findAll());
    }

    @GetMapping("/book")
    public ResponseEntity getBookByBaName(@Valid @RequestParam("name") @Size(max = 6,message = "姓名超过长度") String name) {
        List<Book> results = bookDao.findAll().stream().filter(book -> book.getName().equals(name)).collect(Collectors.toList());
        return ResponseEntity.ok(results);
    }

    @PostMapping("/book/update")
    public ResponseEntity postUpdateBook(@RequestBody @Valid Book book) {
        Book oldbook = bookDao.findOnlyBookById(book.getId());
        oldbook.setName(book.getName());
        oldbook.setDescription(book.getDescription());
        return ResponseEntity.ok(book);
    }

    @GetMapping("/bookbydesc")
    public ResponseEntity getBookLikeBydesc(@RequestParam("description") String description) {
        System.out.println(description);
        List<Book> books = bookDao.findByDescriptionCustome(description);
        return ResponseEntity.ok(books);

    }
    @GetMapping("/test")
    public ResponseEntity arryTest(){

        return ResponseEntity.ok("");
    }
}
