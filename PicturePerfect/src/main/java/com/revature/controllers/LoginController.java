<<<<<<< HEAD
=======

>>>>>>> PPBackDev
package com.revature.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UserService us;

	@PostMapping
	public ResponseEntity<User> login(@Valid @RequestBody User user) {
		User temp = us.login(user.getUsername(), user.getPassword());
		if (temp == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);
		}
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> PPBackDev
