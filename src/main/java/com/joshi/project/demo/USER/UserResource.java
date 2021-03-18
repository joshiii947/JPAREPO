package com.joshi.project.demo.USER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    // retrieveAllUsers

    // retrieveUser(int id)

    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    private List<User> retrieveAllUsers(){

        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        User user=service.findOne(id);
        if(user==null)
            throw new UserNotFoundException("id-"+id);

        return service.findOne(id);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        User savedUser=service.save(user);

         URI location=ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
