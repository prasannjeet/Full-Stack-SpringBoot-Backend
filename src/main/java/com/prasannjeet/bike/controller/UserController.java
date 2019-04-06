package com.prasannjeet.bike.controller;

import com.prasannjeet.bike.models.User;
import com.prasannjeet.bike.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //create
    //@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String create(@RequestBody User user) {
        userRepository.save(user);
        return "Added User with id: "+user.getId();
    }

    //read -> GET
    @RequestMapping(value ="/{id}")
    public User read (@PathVariable String id) {
        return userRepository.findOneById(id);
    }

    //update
    //@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update (@RequestBody User user) {
        userRepository.save(user);
    }

    //delete
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable String id) {
        userRepository.deleteById(id);
    }
}
