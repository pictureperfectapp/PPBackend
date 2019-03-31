package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.models.User;
import com.revature.services.UserService;

=======

import com.revature.models.User;
import com.revature.services.UserService;
>>>>>>> 84fc4a19d8f0240e15b8bdf7c7a901754be61324
//Allows access from all origins/ports || Removes CORS policy when trying to access from Angular (port 4200)
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RequestMapping("/users")
public class UserController {
<<<<<<< HEAD
	
	@Autowired
	UserService userService;
	
	
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public User findUserById(@PathVariable("id") Integer id) {
		return userService.getUserById(id);
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		List<User> users = userService.getAllUsers();
		for(User u : users) {
			if(u.getU_id()==user.getU_id()) {
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
			if(u.getU_id()==id) {
				// then we want to update that record
				user.setU_id(id);
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
	
	
	
	

=======
    
    @Autowired
    UserService userService; 
    
    @GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public User findUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }
    
    @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        List<User> users = userService.getAllUsers();
        for(User u : users) {
            if(u.getU_id()==user.getU_id()) {
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
            if(u.getU_id()==id) {
                // then we want to update that record
                user.setU_id(id);
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
    
>>>>>>> 84fc4a19d8f0240e15b8bdf7c7a901754be61324
}
