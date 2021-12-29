package com.bookmark.bookmark.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmark.bookmark.entity.User;
import com.bookmark.bookmark.repository.UserRepository;
import com.bookmark.bookmark.helper.CommonFunction;
import lombok.NonNull;

/**
 * This class will implement user services methods
 */

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CommonFunction commonFunction;

	/**
	 * {@inheritDoc}
	 */

	@Override
	public User login(@NonNull String email) {
		LOGGER.info("Email to find user at user service -> " + email);
		User filterUser = this.userRepo.findByEmail(email);
		LOGGER.info("findByEmail at user service -> " + filterUser);
		return filterUser;
	}

	/**
	 * {@inheritDoc}
	 */

	@Override
	public User getDefaultUser() {
		User filterUser = this.userRepo.findByEmail("admin@admin.com");
		LOGGER.info("findByEmail at user service -> " + filterUser);
		return filterUser;
	}

	/**
	 * {@inheritDoc}
	 */

	@Override
	public User registerNewUser(User user) {
		LOGGER.info("registerNewUser at user service -> " + user.getEmail());
		user.setSlug(this.commonFunction.getAlphaNumericString(10));
		user.setActive(false);
		user.setBlocked(false);
		user.setDeleted(false);
		user.setEmailToken(this.commonFunction.getAlphaNumericString(50));
		return this.userRepo.save(user);
	}

	// TODO: Add more check and message like not inactive account
	// 1. User is blocked
	// 2. User is deleted
	// 3. User does not excites
	// TODO: Implement JWT
}
