package com.bookmark.bookmark.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmark.bookmark.entity.User;
import com.bookmark.bookmark.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public ResponseEntity<HttpStatus> home() {
		LOGGER.info("Home page loaded ");
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@GetMapping("/login")
	public User login() {
		LOGGER.info("Login function get called ");
		User loginUser = this.userService.login("user@gmail.com");
		if(loginUser.getName() != null) {			
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
	}

}
