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

import com.bookmark.bookmark.entity.BookMark;
import com.bookmark.bookmark.entity.User;
import com.bookmark.bookmark.service.BookMarkService;
import com.bookmark.bookmark.service.UserService;

/**
 * Rest Controller for book mark related logic
 * 
 * @author Rajat
 * 
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/bookmark")
public class BookMarkController {

    /**
     * Logging service
     */
	
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(BookMarkController.class);

    /**
     * book mark related logic service
     */
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private BookMarkService bookMarkService;    
    
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
    public ResponseEntity<BookMark> getBookMarkByCategoryId(@PathVariable("id") long id ) throws Exception {
        LOGGER.info("getBookMarkListByCategory page loaded ");
        BookMark bookMarkList = this.bookMarkService.getBookMarkBasedOnCategoryId(id);
        return ResponseEntity.ok(bookMarkList);
    }
    
    /**
     * This method get book mark and it required
     * authorization
     * 
     * 
     * @param none
     * @return ok status
     * @throws exception
     * 
     */
    
    @GetMapping("/list")
    public ResponseEntity<List<BookMark>> getBookMarkListByUser() throws Exception {
        LOGGER.info("getBookMarkListByUser page loaded ");
        User user = this.userService.getDefaultUser();
        List<BookMark> bookMarkList = this.bookMarkService.getBookMarkListBasedOnLoginUser(user.getId());
        return ResponseEntity.ok(bookMarkList);
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
    
    @GetMapping("/collection/{collectionId}")
    public ResponseEntity<List<BookMark>> getBookMarkListByCollection(@PathVariable("collectionId") long collectionId ) throws Exception {
        LOGGER.info("getBookMarkListByCollection page loaded ");
        List<BookMark> bookMarkList = this.bookMarkService.getBookMarkListBasedOnCollection(collectionId);
        return ResponseEntity.ok(bookMarkList);
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
    
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<BookMark>> getBookMarkListByCategory(@PathVariable("categoryId") long categoryId ) throws Exception {
        LOGGER.info("getBookMarkListByCategory page loaded ");
        List<BookMark> bookMarkList = this.bookMarkService.getBookMarkListBasedOnCategory(categoryId);
        return ResponseEntity.ok(bookMarkList);
    }
    

}
