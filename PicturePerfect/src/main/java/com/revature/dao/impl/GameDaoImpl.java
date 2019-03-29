package com.revature.dao.impl;

import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.Session;

import com.revature.beans.Game;
import com.revature.dao.GameDao;
import com.revature.util.HibernateUtil;

public class GameDaoImpl implements GameDao{

	@Override
	public List<Game> getAllGames() {
		Session s = HibernateUtil.getSession();
		List<Game> games = s.createCriteria(Game.class).list();
		s.close();
		return games;
	}

	@Override
	public Game getGameById(int id) {
		Session s = HibernateUtil.getSession();
		Game g = (Game) s.get(Game.class, id);
		s.close();
		return g;
	}

	@Override
	public Game createGame(Game game) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.save(game);
		tx.commit();
		s.close();
		return game;
	}

	@Override
	public Game updateGame(Game game) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(game);
		tx.commit();
		s.close();
		return game;
	}

	@Override
	public void deleteGame(Game game) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(game);
		tx.commit();
		s.close();
	}

}
