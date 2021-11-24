package com.bookmark.bookmark.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bookmark.bookmark.entity.Collection;


public interface CollectionRepository extends CrudRepository<Collection, Long> {
	
	List<Collection> findByUser(long id);

}
