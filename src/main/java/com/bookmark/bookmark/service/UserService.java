package com.bookmark.bookmark.service;

import com.bookmark.bookmark.entity.User;

/**
 * UserService interface for User entity
 */

public interface UserService {

    /**
     * find user by email
     * 
     * @param email
     * @return User
     */

    User login(String email);

    /**
     * get default user while not logged implemented
     * 
     * @return
     */

    User getDefaultUser();

    /**
     * add new user
     * 
     * @param newUser
     * @return User
     */

    User registerNewUser(User newUser);

}
