package com.bookmark.bookmark.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookmark.bookmark.entity.User;

import lombok.NonNull;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByEmail(@NonNull String email);
}
