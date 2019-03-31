package com.revature.services;

import java.util.List;

<<<<<<< HEAD
import com.revature.models.Game;

public class GameServiceImpl implements GameService{

	@Override
	public List<Game> getAllGames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Game getGameById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Game createGame(Game game) {
		// TODO Auto-generated method stub
		return null;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Game;
import com.revature.repositories.GameRepository;

@Service
public class GameServiceImpl implements GameService{

	@Autowired
	GameRepository gameRepository;
	
	@Override
	public List<Game> findAllGames() {
		return gameRepository.findAll();
	}

	@Override
	public Game findGameById(int id) {
		return gameRepository.getOne(id);
	}

	@Override
	public Game addGame(Game game) {
		return gameRepository.save(game);
>>>>>>> 84fc4a19d8f0240e15b8bdf7c7a901754be61324
	}

	@Override
	public Game updateGame(Game game) {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteGame(Game game) {
		// TODO Auto-generated method stub
		
	}

=======
		game.setTurn(game.getTurn()+1);
		return gameRepository.save(game);
	}

	@Override
	public Game deleteGame(Game game) {
		gameRepository.delete(game);
		return game;
	}



>>>>>>> 84fc4a19d8f0240e15b8bdf7c7a901754be61324
}
