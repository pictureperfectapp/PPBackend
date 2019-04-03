package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Game;
import com.revature.models.User;
import com.revature.repositories.GameRepository;
import com.revature.repositories.UserRepository;
import com.revature.util.EmailUtil;

@Service
public class GameServiceImpl implements GameService {

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
			EmailUtil.sendEmail(users.get(1).getEmail(),
					"You Received an Image to Guess from : " + users.get(0).getUsername());
		} catch (Exception e) {
			System.out.println("Email not valid or can not be reached");
		}
		game.setGuess("NEED TO GUESS");
		return gameRepository.save(game);
	}

	@Override
	public Game updateGame(Game game) {

		List<User> users = game.getUsers();
		try {
			EmailUtil.sendEmail(users.get(0).getEmail(), users.get(1).getUsername()
					+ " has guessed, Checkout PicturePerfect to see if the guess is correct!");
		} catch (Exception e) {
			System.out.println("Email is not valid or can not be reached");
		}
		if (((Integer) game.getTurn()).equals(game.getUsers().get(1).getuId())) {
			for (User u : users) {
				u.setGamesPlayed(u.getGamesPlayed() + 1);
				String[] guesses = game.getGuess().split(" ");
				for (String g : guesses) {
					if (g.equalsIgnoreCase(game.getWord())) {
						u.setWins(u.getWins() + 1);
					}
					userRepository.save(u);
				}
			}
			game.setTurn(game.getUsers().get(0).getuId());
		} else {
			game.setTurn(-1);
		}
		return gameRepository.save(game);
	}

	@Override
	public Game deleteGame(Game game) {
		gameRepository.delete(game);
		return game;
	}

	@Override
	public List<Game> findGamesByTurn(Integer id) {
		return gameRepository.findGamesByTurn(id);
	}

}
