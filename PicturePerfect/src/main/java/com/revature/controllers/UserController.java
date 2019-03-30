package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

//Allows access from all origins/ports || Removes CORS policy when trying to access from Angular (port 4200)
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class UserController {

}
