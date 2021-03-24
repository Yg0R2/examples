package yg0r2.examples.user.service;

import yg0r2.examples.user.api.model.CreateUserRequest;
import yg0r2.examples.user.dao.model.UserEntity;
import yg0r2.examples.user.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public UserEntity createUser(CreateUserRequest createUserRequest) {
        UserEntity userEntity = new UserEntity();

        userEntity.setPassword(createUserRequest.getPassword());
        userEntity.setUserName(createUserRequest.getUserName());

        return userRepository.save(userEntity);
    }

    public Optional<UserEntity> findUserByName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public boolean isExist(String userName, String password) {
        UserEntity userEntity = findUserByName(userName)
            .orElseThrow(() -> new RuntimeException("User doesn't exist with userName: " + userName));

        return passwordEncoder.matches(password, userEntity.getPassword());
    }

}
