package com.bookmark.bookmark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmark.bookmark.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
