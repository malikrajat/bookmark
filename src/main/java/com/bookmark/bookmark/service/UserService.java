package com.bookmark.bookmark.service;

//import java.util.ArrayList;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User.UserBuilder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
	
	public User getDefaultUser() {
		User filterUser = this.userRepo.findByEmail("admin@admin.com");
		LOGGER.info("findByEmail at user service -> " + filterUser);
		return filterUser;
	}

//	TODO: Add more check and message like not inactive account
//	1. User is blocked
//	2. User is deleted
//	3. User does not excites

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		LOGGER.info("username -> " + username);
//		UserDetails userDetail = this.userRepo.findByEmail(username);
//		LOGGER.info("username response -> " + userDetail);
//		return userDetail;
//	}
	
//	@Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        UserBuilder builder = null;
//        User user = this.userRepo.findByEmail(email);
//        if (user==null) {
//            throw new UsernameNotFoundException(email);
//        }else{
//            builder = org.springframework.security.core.userdetails.User.withUsername(email);
//            builder.password(user.getPassword());
//        }
//        return builder==null ? null : builder.build();
//    }
	
	

}
