package yg0r2.examples.user;

import yg0r2.examples.user.api.model.CreateUserRequest;
import yg0r2.examples.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DummyDataPopulatorCommandLineRunner implements CommandLineRunner {

    private static final String PASSWORD = "test";
    private static final String USER_NAME = "test";

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) {
        CreateUserRequest createUserRequest = new CreateUserRequest.Builder()
            .withPassword(passwordEncoder.encode(PASSWORD))
            .withUserName(USER_NAME)
            .build();

        userService.createUser(createUserRequest);
    }

}
