package yg0r2.examples.auth.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import yg0r2.examples.auth.api.model.LoginRequest;
import yg0r2.examples.auth.api.model.LoginResponse;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/login")
public class LogInRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogInRestController.class);
    private static final String SESSION_ATTRIBUTE_USER_NAME = "user-name";

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public LoginResponse login(@Valid LoginRequest loginRequest, HttpServletRequest servletRequest) {
        Authentication authentication = authenticationManager.authenticate(createAuthentication(loginRequest));

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);

        SecurityContextHolder.setContext(context);

        if (servletRequest.getSession().getAttribute(SESSION_ATTRIBUTE_USER_NAME) == null) {
            LOGGER.info("Store user name into session.");

            servletRequest.getSession().setAttribute(SESSION_ATTRIBUTE_USER_NAME, loginRequest.getUserName());
        }

        return new LoginResponse.Builder()
            .withUserName(loginRequest.getUserName())
            .build();
    }

    private Authentication createAuthentication(LoginRequest loginRequest) {
        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("USER"));

        return new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword(), authorities);
    }

}
