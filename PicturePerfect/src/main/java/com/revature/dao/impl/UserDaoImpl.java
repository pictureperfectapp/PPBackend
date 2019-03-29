package com.revature.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.User;
import com.revature.dao.UserDao;
import com.revature.util.HibernateUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public List<User> getAllUsers() {
		Session s = HibernateUtil.getSession();
		List<User> users = s.createCriteria(User.class).list();
		s.close();
		return users;
	}

	@Override
	public User getUserById(int id) {
		Session s = HibernateUtil.getSession();
		User u = (User) s.get(User.class, id);
		s.close();
		return u;
	}

	@Override
	public User createUser(User user) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.save(user);
		tx.commit();
		s.close();
		return user;
	}

	@Override
	public User updateUser(User user) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(user);
		tx.commit();
		s.close();
		return user;
	}

	@Override
	public void deleteUser(User user) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(user);
		tx.commit();
		s.close();
	}
	
}
