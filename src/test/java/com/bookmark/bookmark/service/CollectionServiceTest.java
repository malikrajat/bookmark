package com.bookmark.bookmark.service;

import com.bookmark.bookmark.entity.Collection;
import com.bookmark.bookmark.entity.User;
import com.bookmark.bookmark.repository.CollectionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CollectionServiceTest {

    @Mock
    private CollectionRepository collectionRepository;

    @InjectMocks
    private CollectionService collectionService;

    @Test
    void getCollectionListBasedOnLoginUser() {
        int userId = 12;
        Collection collection = new Collection();
        List<Collection> collectionList = new ArrayList<Collection>();
        Mockito.when(this.collectionRepository.findByUser(userId)).thenReturn(collectionList);
        List<Collection> collectionListBasedOnLoginUser = this.collectionService.getCollectionListBasedOnLoginUser(userId);
        assertNotNull(collectionListBasedOnLoginUser);
    }

    @Test
    void getCollectionById() {
        int collectionId = 12;
        Collection collection = new Collection();
        Mockito.when(this.collectionRepository.findById(collectionId)).thenReturn(collection);
        Collection collectionRes = this.collectionService.getCollectionById(collectionId);
        assertNotNull(collectionRes);
    }
}