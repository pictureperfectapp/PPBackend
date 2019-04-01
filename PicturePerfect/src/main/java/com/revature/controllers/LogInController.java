package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.models.User;
import com.revature.services.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller

@RequestMapping("/logIn")
public class LogInController {

	 @Autowired
	    UserService userService;
	 
	 @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	    public Integer LogIn(HttpServletRequest request,@PathVariable("username") String username, @PathVariable("password") String password) {
	        List<User> users = userService.getAllUsers();
	        for(User u : users) {
	            if(u.getUsername()==username && u.getPassword()==password) {
	            	HttpSession session = request.getSession();
	            	session.setAttribute("username", username);
	            	session.setAttribute("password", password);
	            	session.setAttribute("email", u.getEmail());
	                return 1;
	                
	            }
	        }
	        // we want to return a 201
	        return 0;
	    }
	
	
}
