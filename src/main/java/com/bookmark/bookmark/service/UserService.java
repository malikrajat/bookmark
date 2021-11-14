package com.bookmark.bookmark.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmark.bookmark.entity.User;
import com.bookmark.bookmark.repository.UserRepository;

import lombok.NonNull;

@Service
public class UserService {
	
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepo;
	
	public User login(@NonNull String email) {
		LOGGER.info("Email to find user at user service -> " + email);
		User filterUser = this.userRepo.findByEmail(email);
		LOGGER.info("findByEmail at user service -> " + filterUser);
		return filterUser;		
	}

}
