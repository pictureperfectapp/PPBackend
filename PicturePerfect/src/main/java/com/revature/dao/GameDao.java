package com.revature.dao;

import java.util.List;

import com.revature.beans.Game;

public interface GameDao{
	public List<Game> getAllGames();
	public Game getGameById(int id);
	public Game createGame(Game game);
	public Game updateGame(Game game);
	public void deleteGame(Game game);
}
