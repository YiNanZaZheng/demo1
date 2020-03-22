package com.example.demo1.controller;

import com.example.demo1.dao.BookRepository;
import com.example.demo1.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BookController {

    private List<Book> books=new ArrayList<>();
    @Autowired
    private final BookRepository bookDao;

    public BookController(BookRepository bookDao) {
        this.bookDao = bookDao;
    }

    @PostMapping("/book")
    public ResponseEntity<List<Book>> addBook(@RequestBody Book book) {
        books.add(book);
        bookDao.save(book);
        return ResponseEntity.ok(bookDao.findAll());
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity deleteBookById(@PathVariable("id") long id) {
        books.remove(id);
        bookDao.deleteById(id);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/book")
    public ResponseEntity getBookByBaName(@RequestParam("name") String name) {
        List<Book> results = books.stream().filter(book -> book.getName().equals(name)).collect(Collectors.toList());
        return ResponseEntity.ok(results);
    }
}
