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

import com.bookmark.bookmark.entity.Collection;
import com.bookmark.bookmark.entity.User;
import com.bookmark.bookmark.service.CollectionService;
import com.bookmark.bookmark.service.UserService;

/**
 * Rest COntroller for collection related logic
 * 
 * @author Rajat
 * 
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/collection")
public class CollectionController {

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
    private CollectionService collectionService;

    /**
     * This method get triggered on collection page load and it required
     * authorization
     * 
     * 
     * @param none
     * @return ok status
     * @throws exception
     * 
     */
    @GetMapping("/list")
    public ResponseEntity<List<Collection>> home() throws Exception {
        LOGGER.info("collection page loaded ");
        User user = this.userService.getDefaultUser();
        List<Collection> collectionList = this.collectionService.getCollectionListBasedOnLoginUser(user.getId());
        System.out.println(collectionList);

        return ResponseEntity.ok(collectionList);
    }
    
    /**
     * This method get collection by id and it required
     * authorization
     * 
     * 
     * @param none
     * @return ok status
     * @throws exception
     * 
     */
    
    @GetMapping("/{id}")
    public ResponseEntity<Collection> getCollectionByCategoryId(@PathVariable("id") long id ) throws Exception {
        LOGGER.info("getCollectionByCategoryId page loaded ");
        Collection collection = this.collectionService.getCollectionById(id);
        return ResponseEntity.ok(collection);
    }

}
