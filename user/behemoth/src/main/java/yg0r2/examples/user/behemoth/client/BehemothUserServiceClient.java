package yg0r2.examples.user.behemoth.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import yg0r2.examples.user.api.client.UserServiceClient;
import yg0r2.examples.user.web.rest.UserRestController;

@Component
public class BehemothUserServiceClient implements UserServiceClient {

    @Autowired
    private UserRestController userRestController;

    @Override
    public boolean isExist(String userName, String password) {
        try {
            return userRestController.isExist(userName, password);
        }
        catch (Exception exception) {
            return false;
        }
    }

}
