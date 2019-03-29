package com.revature.repositories;

import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository
public class UserRepository extends JpaRepository<User, Integer>{
	
}
