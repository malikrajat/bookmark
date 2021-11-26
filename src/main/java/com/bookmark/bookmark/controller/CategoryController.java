package com.bookmark.bookmark.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmark.bookmark.entity.Category;
import com.bookmark.bookmark.entity.User;
import com.bookmark.bookmark.service.CategoryService;
import com.bookmark.bookmark.service.UserService;

/**
 * Rest COntroller for collection related logic
 * 
 * @author Rajat
 * 
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {

    /**
     * Logging service
     */
	
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CategoryController.class);

    /**
     * User related logic service
     */
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private CategoryService categoryService;
    
    /**
     * This method get book mark by id and it required
     * authorization
     * 
     * 
     * @param none
     * @return ok status
     * @throws exception
     * 
     */
    
    @GetMapping("/{id}")
    public ResponseEntity<Category> getBookMarkByCategoryId(@PathVariable("id") long id ) throws Exception {
        LOGGER.info("getBookMarkListByCategory page loaded ");
        Category categoryList = this.categoryService.getCategoryById(id);
        return ResponseEntity.ok(categoryList);
    }
    
    /**
     * This method get category and it required
     * authorization
     * 
     * 
     * @param none
     * @return ok status
     * @throws exception
     * 
     */
    
    @GetMapping("/list")
    public ResponseEntity<List<Category>> home() throws Exception {
        LOGGER.info("collection page loaded ");
        User user = this.userService.getDefaultUser();
        List<Category> categoryList = this.categoryService.getCategoryListBasedOnLoginUser(user.getId());
        return ResponseEntity.ok(categoryList);
    }
    
    /**
     * This method get category based on collection id and it required
     * authorization
     * 
     * 
     * @param none
     * @return ok status
     * @throws exception
     * 
     */
    
    @GetMapping("/collection/{collectionId}")
    public ResponseEntity<List<Category>> getCategoryByCollection(@PathVariable("collectionId") long collectionId ) throws Exception {
        LOGGER.info("getCategoryByCollection page loaded ");
        List<Category> categoryList = this.categoryService.getCategoryListBasedOnCollection(collectionId);
        return ResponseEntity.ok(categoryList);
    }
    
}
