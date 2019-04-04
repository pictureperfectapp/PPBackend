package com.revature;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.models.Game;
import com.revature.models.User;
import com.revature.repositories.GameRepository;
import com.revature.repositories.UserRepository;
import com.revature.services.GameService;
import com.revature.services.GameServiceImpl;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

@RunWith(SpringRunner.class)
public class ServiceTesting {

	@TestConfiguration
	static class ServiceImplTestContextConfiguration {

		@Bean
		public UserService userService() {
			return new UserServiceImpl();
		}
		
		@Bean
		public GameService gameService() {
			return new GameServiceImpl();
		}
	}
	
	

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	List<User> userRepo = new ArrayList<>();
	List<User> gameList = new ArrayList<>();
	@Autowired
	private GameService gameService;

	@MockBean
	private GameRepository gameRepository;

	List<Game> gameRepo = new ArrayList<>();

	@Before
	public void setUp() {
		List<User> users = new ArrayList<>();
		User alex = new User(1);
		User jim = new User(3);
		User sam = new User(4);
		User bob = new User(50, null, null, null, "No", 0, 0, 0);
		User sammy = new User("Sammy");
		User testBot = new User(100, "user", "password", "email", "No", 0, 0, 0);

		users.add(alex);
		users.add(jim);
		users.add(sam);
		gameList.add(alex);
		gameList.add(jim);

		this.userRepo = users;
		
		Game one = new Game (1, "hi", "hi", "NEED TO GUESS", 1, gameList);
		Game two = new Game (1, "hi", "hi", "NEED TO GUESS", -1, gameList);
		
		Mockito.when(userRepository.getOne(1)).thenReturn(alex);
		Mockito.when(userRepository.getOne(2)).thenReturn(null);
		Mockito.when(userRepository.findAll()).thenReturn(users);
		Mockito.when(userRepository.findUserByUsername("Sammy")).thenReturn(sammy);
		Mockito.when(userRepository.findUserByUsername("user")).thenReturn(testBot);
		Mockito.when(userRepository.save(bob)).thenReturn(bob);
		Mockito.when(gameRepository.getOne(1)).thenReturn(one);
		Mockito.when(gameRepository.findAll()).thenReturn(gameRepo);
		Mockito.when(gameRepository.save(one)).thenReturn(one);
		Mockito.when(gameRepository.save(two)).thenReturn(two);
	}

	@Test
	public void retrieveExistingUser() {
		Integer id = 1;
		User found = userService.getUserById(1);

		assertEquals(found.getuId(), id);
	}

	@Test
	public void retrieveNonExistingUser() {
		Integer id = 2;
		User found = userService.getUserById(id);

		assertEquals(found, null);
	}

	@Test
	public void retrieveAllUsers() {
		List<User> found = userService.getAllUsers();

		assertEquals(found, userRepo);
	}

	@Test
	public void retrieveExistingUserByUsername() {
		String name = "Sammy";
		User found = userService.getUserByUsername(name);

		assertEquals(found.getUsername(), "Sammy");
	}

	@Test
	public void retrieveNonExistingUserByUsername() {
		String name = "Sally";
		User found = userService.getUserByUsername(name);

		assertEquals(found, null);
	}
	
	@Test
	public void createUser() {
		User bob = new User(50, null, null, null, "No", 0, 0, 0);
		assertEquals(userService.createUser(bob), bob);
	}

	@Test
	public void login() {
		User testBot = new User(100, "user", null, "email", "No", 0, 0, 0);
		assertEquals(userService.login("user", "password"), testBot);
	}

	@Test
	public void saveUser() {
		User bob = new User(50, null, null, null, "No", 0, 0, 0);
		assertEquals(userService.updateUser(bob), bob);
	}
	
	@Test
	public void retrieveExistingGame() {
		Integer id = 1;
		Game found = gameService.findGameById(id);

		assertEquals(found.getG_id(), id);
	}
	
	@Test
	public void retrieveNonExistingGame() {
		Integer id = 2;
		Game found = gameService.findGameById(id);

		assertEquals(found, null);
	}
	
	@Test
	public void retrieveAllGames() {
		List<Game> found = gameService.findAllGames();

		assertEquals(found, gameRepo);
	}
	
	@Test
	public void createGame() {
		Game one = new Game (1, "hi", "hi", "hi", 1, gameList);
		assertEquals(gameService.addGame(one), one);
	}
	
	@Test
	public void saveGame() {
		Game one = new Game (1, "hi", "hi", "NEED TO GUESS", -1, gameList);
		assertEquals(gameService.updateGame(one), one);
	}
	
	@Test
	public void deleteGame() {
		Game one = new Game (1, "hi", "hi", "hi", -1, gameList);
		assertEquals(gameService.deleteGame(one), one);
	}
}