package com.revature.repositories;


import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.models.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer>{
	
	public List<Game> findGamesByTurn(Integer id);
}
