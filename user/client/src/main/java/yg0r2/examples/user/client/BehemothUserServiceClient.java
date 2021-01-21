package yg0r2.examples.user.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import yg0r2.examples.user.web.rest.UserRestController;

@Component
@ConditionalOnProperty(name = "examples.behemoth", havingValue = "true")
public class BehemothUserServiceClient implements UserServiceClient {

    @Autowired
    private UserRestController userRestController;

    @Override
    public ResponseEntity<Boolean> isExist(String userName, String password) {
        return ResponseEntity.ok(userRestController.isExist(userName, password));
    }

}
