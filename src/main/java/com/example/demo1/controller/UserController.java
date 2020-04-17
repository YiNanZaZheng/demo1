package com.example.demo1.controller;

import com.example.demo1.entity.User;
import com.example.demo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public ResponseEntity getUserByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(userService.selectUserByName(name));
    }

    @GetMapping("/user/all")
    public ResponseEntity getAllUser() {
        return ResponseEntity.ok(userService.selectAllUser());
    }

    @PostMapping("/user")
    public ResponseEntity addUser(@RequestBody User user) {
        userService.insertUser(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok("");
    }

    @GetMapping("/transaction")
    public void changeMoney() {
        userService.changMoney();
    }

}
