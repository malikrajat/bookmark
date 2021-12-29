package com.bookmark.bookmark.service;

import com.bookmark.bookmark.entity.Category;
import com.bookmark.bookmark.entity.Collection;
import com.bookmark.bookmark.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CategoryService categoryService;

    @Test
    void getCategoryListBasedOnLoginUser() {
        int userId = 12;
        Category category = new Category();
        List<Category> collectionList = new ArrayList<Category>();
        Mockito.when(this.categoryRepository.findByUser(userId)).thenReturn(collectionList);
        List<Category> categoryListBasedOnLoginUser = this.categoryService.getCategoryListBasedOnLoginUser(userId);
        assertNotNull(categoryListBasedOnLoginUser);
    }

    @Test
    void getCategoryListBasedOnCollection() {
        int userId = 12;
        Category category = new Category();
        List<Category> collectionList = new ArrayList<Category>();
        Mockito.when(this.categoryRepository.findByCollection(userId)).thenReturn(collectionList);
        List<Category> categoryListBasedOnLoginUser = this.categoryService.getCategoryListBasedOnCollection(userId);
        assertNotNull(categoryListBasedOnLoginUser);
    }

    @Test
    void getCategoryById() {
        int categoryId = 1;
        Category category = new Category();
        Mockito.when(this.categoryRepository.findById(categoryId)).thenReturn(category);
        Category categoryRes = this.categoryService.getCategoryById(categoryId);
        assertNotNull(categoryRes);
    }
}