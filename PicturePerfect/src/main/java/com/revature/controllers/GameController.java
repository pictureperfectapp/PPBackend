package com.revature.controllers;

<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
=======
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

import com.revature.models.Game;
import com.revature.services.GameService;
>>>>>>> 84fc4a19d8f0240e15b8bdf7c7a901754be61324

//Allows access from all origins/ports || Removes CORS policy when trying to access from Angular (port 4200)
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
<<<<<<< HEAD
public class GameController {

=======
@RequestMapping("/games")
public class GameController {
	@Autowired
	GameService gameService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Game> findAllGames(){
		return gameService.findAllGames();
	}
	
	@GetMapping(value = "/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Game findGameById(@PathVariable("id") Integer id) {
		return gameService.findGameById(id);
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Game> addGame(@Valid @RequestBody Game game){
		return new ResponseEntity<Game>(gameService.addGame(game), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Game> updateGame(@PathVariable("id") Integer id, @Valid @RequestBody Game game){
		List<Game> games = gameService.findAllGames();
		for (Game g : games) {
			if(g.getG_id() == id) {
				game.setG_id(id);
				return new ResponseEntity<>(gameService.updateGame(game), HttpStatus.OK);
			}
		}
		return new ResponseEntity<Game>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public Game deleteGame(@PathVariable("id") Integer id) {
		Game game = new Game(id);
		return gameService.deleteGame(game);
	}
>>>>>>> 84fc4a19d8f0240e15b8bdf7c7a901754be61324
}
