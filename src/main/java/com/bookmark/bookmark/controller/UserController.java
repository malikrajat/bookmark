package com.bookmark.bookmark.controller;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
//@RequestMapping("/user")
public class UserController {

	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UserController.class);

	@GetMapping("/")
	public ResponseEntity<HttpStatus> home() {
		LOGGER.info("Home page loaded ");
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

}
