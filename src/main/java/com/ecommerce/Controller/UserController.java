package com.ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Dto.LoginRequest;
import com.ecommerce.Entity.User;
import com.ecommerce.Service.UserService;
import com.ecommerce.security.JWTTokenProvider;
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
    private UserService userService;

	 @Autowired
	 private AuthenticationManager authenticationManager;
	 
	 @Autowired
	 private JWTTokenProvider jwtTokenProvider;
	 
    public UserController(UserService userService) {
		this.userService = userService;
		
	}

	@PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginDto){
		Authentication authentication=
			authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginDto.getEmail(), loginDto.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token=jwtTokenProvider.generateToken(authentication);
		return new ResponseEntity<>(token,HttpStatus.OK);
		
		
	}
   
}
