package yg0r2.examples.layout;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Component
public class ApplicationInitializer implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.getSessionCookieConfig().setHttpOnly(true); // if true then browser script won't be able to access the cookie
        servletContext.getSessionCookieConfig().setSecure(true); // if true then the cookie will be sent only over HTTPS connection
    }

}
