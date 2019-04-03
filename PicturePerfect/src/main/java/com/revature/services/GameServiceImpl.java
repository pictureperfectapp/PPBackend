package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Game;
import com.revature.models.User;
import com.revature.repositories.GameRepository;
import com.revature.repositories.UserRepository;
import com.revature.util.EmailUtil;

@Service
public class GameServiceImpl implements GameService{

	@Autowired
	GameRepository gameRepository;
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<Game> findAllGames() {
		return gameRepository.findAll();
	}

	@Override
	public Game findGameById(Integer id) {
		return gameRepository.getOne(id);
	}

	@Override
	public Game addGame(Game game) {
		List<User> users = game.getUsers();
		try {
			EmailUtil.sendEmail(users.get(1).getEmail(), "You Recieved an Image to Guess from : " + users.get(0).getUsername());
		} catch (Exception e) {
			System.out.println("Email not valid or can not be reached");
		}
		game.setGuess("NEED TO GUESS");
		game.setTurn(1);
		return gameRepository.save(game);
	}

	@Override
	public Game updateGame(Game game) {
		game.setTurn(game.getTurn() + 1);
		List<User> users = game.getUsers();
		if(game.getTurn() == 2) {	
			try {
				EmailUtil.sendEmail(users.get(0).getEmail(), users.get(1).getUsername() + " has guessed, Checkout PicturePerfect to see if the guess is correct!");
				if(game.getGuess() == game.getWord()) {
					for(User u : users) {
						u.setWins(u.getWins()+1);
						userRepository.save(u);
					}
				}
			} catch (Exception e) {
				System.out.println("Email is not valid or can not be reached");
			}
		}
		return gameRepository.save(game);
	}

	@Override
	public Game deleteGame(Game game) {
		gameRepository.delete(game);
		return game;
	}

	@Override
	public List<Game> findGameByUserId(Integer id){
		List<Game> allGames = gameRepository.findByUsers_uId(id);
		List<Game> resumable = new ArrayList<Game>();
		for(Game g : allGames) {
			if(g.getTurn() == 2) {
				resumable.add(g);
			}
		}
		return resumable;
	}



}
