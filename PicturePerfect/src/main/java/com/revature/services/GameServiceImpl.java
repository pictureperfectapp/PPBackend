package com.revature.services;

import java.util.ArrayList;
import java.util.List;

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
	}

	@Override
	public Game updateGame(Game game) {
		game.setTurn(game.getTurn()+1);
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
