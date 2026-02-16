package com.ecommerce.Service;

import java.util.List;

import com.ecommerce.Entity.User;

public interface UserService {

	 User createUser(User user);

	    List<User> getAllUsers();

	    User getUserById(long id);
	    
	    void deleteUser(long id);
}
