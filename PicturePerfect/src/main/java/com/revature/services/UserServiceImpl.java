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
    	user.setGamesPlayed(0);
    	user.setPoints(0);
    	user.setWins(0);
    	user.setAdmin("No");
        return userRepository.save(user);
    
    }
    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public void deleteUser(User user) {
    	//Not needed
    }
	@Override
	public User getUserByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}
	
	@Override
	public User login(String username, String password) {
		User temp = new User();
		User retrievedUser = this.getUserByUsername(username);
		if(retrievedUser != null && retrievedUser.getPassword().equals(password)) {
			temp.setuId(retrievedUser.getuId());
			temp.setUsername(username);
			temp.setEmail(retrievedUser.getEmail());
			temp.setGamesPlayed(retrievedUser.getGamesPlayed());
			temp.setPoints(retrievedUser.getPoints());
			temp.setWins(retrievedUser.getWins());
			temp.setAdmin(retrievedUser.getAdmin());
		}
		return temp;
	}
}