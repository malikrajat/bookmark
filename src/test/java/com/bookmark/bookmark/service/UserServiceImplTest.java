package com.bookmark.bookmark.service;

import com.bookmark.bookmark.entity.User;
import com.bookmark.bookmark.helper.CommonFunction;
import com.bookmark.bookmark.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private CommonFunction commonFunction;

    @Mock
    private UserRepository userRepository;

    @Test
    void login() {
        String email = "admin@admin.com";
        User userInstance = new User();
        Mockito.when(userRepository.findByEmail(email)).thenReturn(userInstance);
        User user = this.userService.login(email);
//        assertTrue(true);
        assertNotNull(user);
    }

    @Test
    void getDefaultUser() {
        String email = "admin@admin.com";
        User userInstance = new User();
        Mockito.when(userRepository.findByEmail(email)).thenReturn(userInstance);
        User user = this.userService.getDefaultUser();
        assertNotNull(user);
    }

    @Test
    void registerNewUser() {
        User userInstance = new User();
        Mockito.when(this.commonFunction.getAlphaNumericString(10)).thenReturn("asdasdsadsa");
        User user = this.userService.registerNewUser(userInstance);
        Mockito.when(userRepository.save(userInstance)).thenReturn(userInstance);
//        assertNotNull(user);
    }
}