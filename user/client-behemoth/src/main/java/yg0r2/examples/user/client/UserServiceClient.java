package yg0r2.examples.user.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import yg0r2.examples.user.web.rest.UserRestController;

@Component
public class UserServiceClient {

    @Autowired
    private UserRestController userRestController;

    public ResponseEntity<Boolean> isExist(String userName, String password) {
        return ResponseEntity.ok(userRestController.isExist(userName, password));
    }

}
