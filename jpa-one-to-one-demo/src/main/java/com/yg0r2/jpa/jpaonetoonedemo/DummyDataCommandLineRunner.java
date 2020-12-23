package com.yg0r2.jpa.jpaonetoonedemo;

import com.yg0r2.jpa.model.Gender;
import com.yg0r2.jpa.model.User;
import com.yg0r2.jpa.model.UserProfile;
import com.yg0r2.jpa.repository.UserProfileRepository;
import com.yg0r2.jpa.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class DummyDataCommandLineRunner implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public void run(String... args) {
        userProfileRepository.deleteAll();
        userRepository.deleteAll();

        User user = createUser();
        UserProfile userProfile = createUserProfile();

        // Set child reference(userProfile) in parent entity(user)
        user.setUserProfile(userProfile);

        // Set parent reference(user) in child entity(userProfile)
        userProfile.setUser(user);

        // Save Parent Reference (which will save the child as well)
        userRepository.save(user);
    }

    private User createUser() {
        return new User("Test", "Test", "test@gmail.com", "test");
    }

    private UserProfile createUserProfile() {
        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(2019, 02, 03);

        return new UserProfile("+xx-xx/xxx-xx-xx", Gender.MALE, dateOfBirth.getTime(), "123", "", "Some Street", "Some City", "", "Some Country", "1234");
    }

}
