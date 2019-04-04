package com.revature.testService;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.revature.models.Game;
import com.revature.models.User;
import com.revature.services.GameServiceImpl;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl; 


public class JUnitTests {

	
	UserService us= new UserServiceImpl();
	GameServiceImpl gs= new GameServiceImpl();
	User AndrewPlus=new User("AndrewPlus", "123", "andrew@hshf.com", null, 0, 0,
			0);
	Game game=new Game();
	List<Game> gameList= new ArrayList();

		@Test
		public void testGetUserById() {
			assertEquals("AndrewPlus", us.getUserById(1952).getUsername());
//			assertEquals("AndrewPlus", "AndrewPlus");

		}
		
		@Test
		public void testGetUserByUsername() {
			
			User temp = us.getUserByUsername("AndrewPlus");
			System.out.println("HI" + temp);
			assertEquals( "AndrewPlus", temp.getUsername());
			System.out.println("Test");
		
			System.out.println(us.getUserByUsername("AndrewPlus"));
		}
		
//		@Test
//		public void testGetGameByUsername() {
//			assertEquals(game, gs.findGameById(1));
//		}
		
//		@Test
//		public void testGetGamesById() {
//			assertEquals(gameList, gs.findGameByUserId(1));
//		}
		
		
		
}
