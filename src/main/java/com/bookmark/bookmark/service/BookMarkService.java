package com.bookmark.bookmark.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmark.bookmark.entity.BookMark;
import com.bookmark.bookmark.repository.BookMarkRepository;

@Service
public class BookMarkService {
	
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(BookMarkService.class);
	
	@Autowired
	private BookMarkRepository bookMarkRepository;
	
	public List<BookMark> getBookMarkListBasedOnLoginUser(long id){
		LOGGER.info("getBookMarkListBasedOnLoginUser  -> " + id);
		return this.bookMarkRepository.findByUser(id);
	}
	
	public List<BookMark> getBookMarkListBasedOnCollection(long id){
		LOGGER.info("getBookMarkListBasedOnCollection  - > " + id);
		return this.bookMarkRepository.findByCollection(id);
	}
	
	public List<BookMark> getBookMarkListBasedOnCategory(long id){
		LOGGER.info("getBookMarkListBasedOnCategory  - > " + id);
		return this.bookMarkRepository.findByCategory(id);
	}
	
	public BookMark getBookMarkBasedOnCategoryId(long id){
		LOGGER.info("getBookMarkBasedOnCategoryId  - > " + id);
		return this.bookMarkRepository.findById(id);
	}
	
	

}
