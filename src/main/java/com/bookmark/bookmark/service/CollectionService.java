package com.bookmark.bookmark.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmark.bookmark.entity.Collection;
import com.bookmark.bookmark.repository.CollectionRepository;

@Service
public class CollectionService {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CollectionService.class);

    @Autowired
    private CollectionRepository collectionRepository;

    public List<Collection> getCollectionListBasedOnLoginUser(long userId) {
        LOGGER.info("" + userId);
        return this.collectionRepository.findByUser(userId);
    }

    public Collection getCollectionById(long id) {
        LOGGER.info("getCollectionById -> " + id);
        return this.collectionRepository.findById(id);
    }

}
