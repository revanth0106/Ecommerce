package com.ecommerce.ServiceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.ecommerce.Entity.User;
import com.ecommerce.Exception.ResourceNotFoundException;
import com.ecommerce.Repository.UserRepository;
import com.ecommerce.Service.UserService;

	@Service
	public class UserServiceImpl implements UserService {
		@Autowired
	    private UserRepository userRepository;
		@Autowired
		private PasswordEncoder passwordEncoder;
		
		 public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
			
			this.userRepository = userRepository;
			this.passwordEncoder = passwordEncoder;
		}


		 @Override
		 public User createUser(User user) {
			 user.setPassword(passwordEncoder.encode(user.getPassword()));
		     return userRepository.save(user);
		 }


	    @Override
	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }

	    @Override
	    public User getUserById(long id) {
	        return userRepository.findById(id)
	                .orElseThrow(() ->
	                        new ResourceNotFoundException("User not found with id: " + id));
	    }
	    @Override
	    public void deleteUser(long id) {

	        User user = userRepository.findById(id)
	                .orElseThrow(() ->
	                        new ResourceNotFoundException("User not found with id: " + id));

	        userRepository.delete(user);
	    }


}
