package com.bookmark.bookmark.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bookmark.bookmark.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	List<Category> findByUser(long id);
	List<Category> findByCollection(long id);

}
