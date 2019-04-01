package com.revature.services;

import java.util.List;

import com.revature.models.User;

public interface UserService {
	public List<User> getAllUsers();
	public User getUserById(int id);
	public User getUserByUsername(String username);
	public User createUser(User user);
	public User updateUser(User user);
	public void deleteUser(User user);
	public User login(String username, String password);
}
