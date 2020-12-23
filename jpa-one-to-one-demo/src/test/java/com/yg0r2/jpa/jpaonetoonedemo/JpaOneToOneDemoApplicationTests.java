package com.yg0r2.jpa.jpaonetoonedemo;

import static org.junit.Assert.assertEquals;

import com.yg0r2.jpa.model.User;
import com.yg0r2.jpa.model.UserProfile;
import com.yg0r2.jpa.repository.UserProfileRepository;
import com.yg0r2.jpa.repository.UserRepository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JpaOneToOneDemoApplicationTests {

    @Autowired
    private UserProfileRepository userProfileRepository;
    @Autowired
    private UserRepository userRepository;

    @BeforeAll
    void initialize() {
        userProfileRepository.deleteAll();
        userRepository.deleteAll();
    }

    @BeforeEach
    void setUp() {
        User user = userRepository.save(createUser());

        userProfileRepository.save(createUserProfile(user));
    }

    @Test
    void testDeleteUser() {
        userRepository.deleteAll();

        assertEquals(0, userRepository.findAll().size());
        assertEquals(0, userProfileRepository.findAll().size());
    }

    @Test
    void testDeleteUserProfile() {
        userProfileRepository.deleteAll();

        assertEquals(1, userRepository.findAll().size());
        assertEquals(0, userProfileRepository.findAll().size());
    }

    private User createUser() {
        User user = new User();

        user.setFirstName("First Name");
        user.setEmail("test@jpa.com");
        user.setPassword("password");

        return user;
    }

    private UserProfile createUserProfile(User user) {
        UserProfile userProfile = new UserProfile();

        userProfile.setUser(user);

        return userProfile;
    }

}

