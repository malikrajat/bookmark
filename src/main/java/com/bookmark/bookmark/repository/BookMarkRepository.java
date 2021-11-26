package com.bookmark.bookmark.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bookmark.bookmark.entity.BookMark;

public interface BookMarkRepository extends CrudRepository<BookMark, Long> {
	List<BookMark> findByUser(long id);
	List<BookMark> findByCollection(long id);
	List<BookMark> findByCategory(long id);
	BookMark findById(long id);

}
