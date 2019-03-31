package com.revature.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.services.ImageService;

//Test Class to retrieve and send images
//Allows access from all origins/ports || Removes CORS policy when trying to access from Angular (port 4200)
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/image")
public class ImageController {

	@Autowired
	ImageService is;

	@GetMapping(value = "/{name}")
	public Map<String, String> getImageByName(@PathVariable("name") String name){
		return is.retrieveImageFromS3(name+".png");
	}

	
	@PostMapping(value = "/{name}")
	public ResponseEntity<Map<String, String>> addImage(@Valid @RequestBody String image, @PathVariable("name") String name) {
		return new ResponseEntity<>(is.uploadImageToS3(name, image), HttpStatus.CREATED);
	}

}
