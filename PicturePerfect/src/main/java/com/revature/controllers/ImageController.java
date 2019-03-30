package com.revature.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Blob;
import java.util.Base64;
import java.util.HashMap;
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
	public Map<String, String> getImageByName(@PathVariable("name") String name) throws IOException {
		File file = is.retrieveBlobFromS3(name+".png");
		String encodeImage = Base64.getEncoder().withoutPadding().encodeToString(Files.readAllBytes(file.toPath()));
		Map<String, String> jsonMap = new HashMap<>();
		jsonMap.put("content", encodeImage);
		return jsonMap;
	}

	@PostMapping
	public ResponseEntity<Blob> addImage(@Valid @RequestBody Blob image) {
		return new ResponseEntity<Blob>(is.uploadBlobToS3(image), HttpStatus.CREATED);
	}

}
