package com.revature.services;
<<<<<<< HEAD

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

=======
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
>>>>>>> 84fc4a19d8f0240e15b8bdf7c7a901754be61324
import com.revature.models.User;
import com.revature.repositories.UserRepository;
@Service
public class UserServiceImpl implements UserService{
<<<<<<< HEAD
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
		
	}

	@Override
	public User getUserById(int id) {
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

}
=======
    @Autowired
    UserRepository userRepository;
    
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
        
    }
    @Override
    public User getUserById(int id) {
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
}
>>>>>>> 84fc4a19d8f0240e15b8bdf7c7a901754be61324
