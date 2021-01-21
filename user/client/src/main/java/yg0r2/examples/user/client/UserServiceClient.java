package yg0r2.examples.user.client;

import org.springframework.http.ResponseEntity;

public interface UserServiceClient {

    ResponseEntity<Boolean> isExist(String userName, String password);

}
