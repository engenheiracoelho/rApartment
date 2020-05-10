package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User insert (@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> list() {
        return new ResponseEntity<List<User>>(
                userRepository.findAll(), HttpStatus.OK
        );
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update (@PathVariable("id") long id,
                                  @RequestBody User user) {
        return userRepository.findById(id)
                .map(record -> {
                    record.setLogin(user.getLogin());
                    record.setPassword(user.getPassword());
                    record.setName(user.getName());
                    record.setApartment(user.getApartment());
                    User updated = userRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = {"/login"})
    public ResponseEntity<User> listUserByLoginAndPassword (@RequestBody User user) {
        return new ResponseEntity<User>(userRepository.findByLoginAndPassword(user.getLogin(),user.getPassword()), HttpStatus.OK);
    }



}