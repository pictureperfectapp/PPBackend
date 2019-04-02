package com.revature.services;

import java.util.List;

import com.revature.models.Game;

public interface GameService{
	public List<Game> findAllGames();
	public List<Game> findGamesByTurn(Integer id);
	public Game findGameById(Integer id);
	public Game addGame(Game game);
	public Game updateGame(Game game);
	public Game deleteGame(Game game);
}
