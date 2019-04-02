package com.revature.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
        
    }
    @Override
    public User getUserById(Integer id) {
        return userRepository.getOne(id);
        
    }
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    
    }
    @Override
    public User updateUser(User user) {
        userRepository.delete(user);
        return user;
    }
    @Override
    public void deleteUser(User user) {
        // TODO Auto-generated method stub
        
    }
	@Override
	public User getUserByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}
	
<<<<<<< HEAD
=======
	@Override
>>>>>>> PPBackDev
	public User login(String username, String password) {
		User temp = new User();
		User retrievedUser = this.getUserByUsername(username);
		if(retrievedUser != null && retrievedUser.getPassword().equals(password)) {
<<<<<<< HEAD
			temp.setU_id(retrievedUser.getU_id());
=======
			temp.setuId(retrievedUser.getuId());
>>>>>>> PPBackDev
			temp.setUsername(username);
			temp.setEmail(retrievedUser.getEmail());
			temp.setGamesPlayed(retrievedUser.getGamesPlayed());
			temp.setPoints(retrievedUser.getPoints());
			temp.setWins(retrievedUser.getWins());
		}
		return temp;
	}
}