package com.bookmark.bookmark.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
public class CatrgoryController {

    /**
     * Logging service
     */
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CollectionController.class);

    /**
     * User related logic service
     */
    @Autowired
    private UserService userService;
    
    @Autowired
    private CategoryService categoryService;
    
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
    @GetMapping("/")
    public ResponseEntity<List<Category>> home() throws Exception {
        LOGGER.info("collection page loaded ");
        User user = this.userService.getDefaultUser();
        List<Category> categoryList = this.categoryService.getCategoryListBasedOnLoginUser(user.getId());
        return ResponseEntity.ok(categoryList);
    }
}
