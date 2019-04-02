package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;
//Allows access from all origins/ports || Removes CORS policy when trying to access from Angular (port 4200)
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    UserService userService; 
    
    
    @GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public User findUserById(@PathVariable("id") Integer id) {
    	System.out.println(id);
    	System.out.println("Hello");
        return userService.getUserById(id);
    }
    
    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public List<User> findUsers() {
        return userService.getAllUsers();
    }
    
    @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        List<User> users = userService.getAllUsers();
        for(User u : users) {
            if(u.getuId()==user.getuId()) {
                // we can throw an exception indicating to the client that the id already exists
                // or we can return a response entity with the appropriate response status
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }
        // we want to return a 201
        return new ResponseEntity<User>(userService.createUser(user),HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @Valid @RequestBody User user) {
        List<User> users = userService.getAllUsers();
        for(User u : users) {
            if(u.getuId()==id) {
                // then we want to update that record
                user.setuId(id);
                return new ResponseEntity<>(userService.updateUser(user),HttpStatus.OK);
            }
        }
        // we want to return a 404
        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        User user = new User(id);
         userService.deleteUser(user);
    }
    
}
