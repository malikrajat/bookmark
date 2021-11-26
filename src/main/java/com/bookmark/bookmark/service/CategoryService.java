package com.bookmark.bookmark.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmark.bookmark.entity.Category;
import com.bookmark.bookmark.repository.CategoryRepository;

@Service
public class CategoryService {
	
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getCategoryListBasedOnLoginUser(long id){
		LOGGER.info("getCategoryListBasedOnLoginUser  -> " + id);
		return this.categoryRepository.findByUser(id);
	}
	
	public List<Category> getCategoryListBasedOnCollection(long id){
		LOGGER.info("getCategoryListBasedOnCollection  - > " + id);
		List<Category> findByCollection = this.categoryRepository.findByCollection(id);		
//		for(Category countData: findByCollection) {
//		    System.out.println(countData.getColor());
//		}
		
		return findByCollection;
	}

}
