package yg0r2.examples.behemoth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import yg0r2.examples.user.api.model.CreateUserRequest;
import yg0r2.examples.user.service.UserService;

@Component
public class DummyDataPopulatorApplicationRunner implements ApplicationRunner {

    private static final String PASSWORD = "test";
    private static final String USER_NAME = "test";

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    @Override
    public void run(ApplicationArguments args) {
        CreateUserRequest createUserRequest = new CreateUserRequest.Builder()
            .withPassword(passwordEncoder.encode(PASSWORD))
            .withUserName(USER_NAME)
            .build();

        userService.createUser(createUserRequest);
    }

}
