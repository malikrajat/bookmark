package com.bookmark.bookmark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmark.bookmark.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
