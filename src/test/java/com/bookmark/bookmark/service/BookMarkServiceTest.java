package com.bookmark.bookmark.service;

import com.bookmark.bookmark.entity.BookMark;
import com.bookmark.bookmark.entity.Collection;
import com.bookmark.bookmark.repository.BookMarkRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookMarkServiceTest {

    @Mock
    private BookMarkRepository bookMarkRepository;

    @InjectMocks
    private BookMarkService bookMarkService;

    @Test
    void getBookMarkListBasedOnLoginUser() {
        int userId = 12;
        Collection collection = new Collection();
        List<BookMark> collectionList = new ArrayList<BookMark>();
        Mockito.when(this.bookMarkRepository.findByUser(userId)).thenReturn(collectionList);
        List<BookMark> collectionListBasedOnLoginUser = this.bookMarkService.getBookMarkListBasedOnLoginUser(userId);
        assertNotNull(collectionListBasedOnLoginUser);
    }

    @Test
    void getBookMarkListBasedOnCollection() {
        int collectionId = 12;
        Collection collection = new Collection();
        List<BookMark> collectionList = new ArrayList<BookMark>();
        Mockito.when(this.bookMarkRepository.findByCollection(collectionId)).thenReturn(collectionList);
        List<BookMark> collectionListBasedOnLoginUser = this.bookMarkService.getBookMarkListBasedOnCollection(collectionId);
        assertNotNull(collectionListBasedOnLoginUser);
    }

    @Test
    void getBookMarkListBasedOnCategory() {
        int categoryId = 12;
        Collection collection = new Collection();
        List<BookMark> collectionList = new ArrayList<BookMark>();
        Mockito.when(this.bookMarkRepository.findByCategory(categoryId)).thenReturn(collectionList);
        List<BookMark> collectionListBasedOnLoginUser = this.bookMarkService.getBookMarkListBasedOnCategory(categoryId);
        assertNotNull(collectionListBasedOnLoginUser);
    }

    @Test
    void getBookMarkBasedOnCategoryId() {
        int categoryId = 12;
        BookMark bookMark = new BookMark();
        Mockito.when(this.bookMarkRepository.findById(categoryId)).thenReturn(bookMark);
        BookMark collectionRes = this.bookMarkService.getBookMarkBasedOnCategoryId(categoryId);
        assertNotNull(collectionRes);
    }
}