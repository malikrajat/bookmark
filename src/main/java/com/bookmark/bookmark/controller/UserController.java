package com.bookmark.bookmark.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookmark.bookmark.entity.User;
import com.bookmark.bookmark.service.UserService;
/**
 * Rest COntroller for User related logic
 * 
 * @author Rajat
 * 
 * */
@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
	
	/**
	 * Logging service 
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UserController.class);
	
	/**
	 * User related logic service
	 */
	@Autowired
	private UserService userService;

	/**
	 * This method get triggered on page load by default and it do not required any authorization
	 * 
	 *  @param none
	 *  @return ok status
	 *  @throws exception
	 *  
	 * */
	@GetMapping("/")
	public ResponseEntity<HttpStatus> home() throws Exception {
		LOGGER.info("Home page loaded ");
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	/**
	 * This method get triggered on login page load and it do not required any authorization
	 * 
	 *  @param none
	 *  @return User or Blank
	 *  @throws exception
	 *  
	 * */
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestParam String email, @RequestParam String password) throws Exception {
		LOGGER.info("Login function get called " + email + " " + password);
		if(email == null || password == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		User loginUser = this.userService.login(email);
		LOGGER.info("Login user details --> " + loginUser);
		if(loginUser != null) {		
			return new ResponseEntity<User>(loginUser, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
//	TODO: why we use ResponseEntity<> as blank 
//	TODO: how to remove password from find query.


}
