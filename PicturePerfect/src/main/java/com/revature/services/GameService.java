package com.revature.services;

import java.util.List;

import com.revature.models.Game;

public interface GameService{
	public List<Game> findAllGames();
	public Game findGameById(int id);
	public Game addGame(Game game);
	public Game updateGame(Game game);
	public Game deleteGame(Game game);
}
