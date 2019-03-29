package com.revature.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.models.Game;

@Repository
public class GameRepository extends JpaRepository<Game, Integer>{

}
