package com.revature.services;

import java.util.List;

import com.revature.models.Game;

public interface GameService{
<<<<<<< HEAD
	public List<Game> getAllGames();
	public Game getGameById(int id);
	public Game createGame(Game game);
	public Game updateGame(Game game);
	public void deleteGame(Game game);
=======
	public List<Game> findAllGames();
	public Game findGameById(int id);
	public Game addGame(Game game);
	public Game updateGame(Game game);
	public Game deleteGame(Game game);
>>>>>>> 84fc4a19d8f0240e15b8bdf7c7a901754be61324
}
