package yg0r2.examples.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import yg0r2.examples.user.client.UserServiceClient;

import java.util.List;
import java.util.Objects;

@Component
public class UserServiceAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserServiceClient userServiceClient;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (Objects.isNull(authentication.getCredentials())) {
            return null;
        }

        String password = authentication.getCredentials().toString();
        String userName = authentication.getName();

        if (!Objects.requireNonNullElse(userServiceClient.isExist(userName, password).getBody(), false)) {
            throw new AuthenticationException("Failed to authenticate user: " + userName) {};
        }

        return new UsernamePasswordAuthenticationToken(userName, password, List.of(new SimpleGrantedAuthority("USER")));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
