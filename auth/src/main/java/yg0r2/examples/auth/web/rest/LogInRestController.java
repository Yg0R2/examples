package yg0r2.examples.auth.web.rest;

import yg0r2.examples.auth.api.model.LoginRequest;
import yg0r2.examples.auth.api.model.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/login")
public class LogInRestController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public LoginResponse login(@Valid LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(createAuthentication(loginRequest));

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);

        SecurityContextHolder.setContext(context);

        return new LoginResponse.Builder()
            .withUserName(loginRequest.getUserName())
            .build();
    }

    private Authentication createAuthentication(LoginRequest loginRequest) {
        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("USER"));

        return new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword(), authorities);
    }

}
