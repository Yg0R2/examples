package yg0r2.examples.behemoth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public final class RequestLoggingFilter extends CommonsRequestLoggingFilter {

    @Autowired
    private LoggingService loggingService;

    @Override
    protected boolean shouldLog(HttpServletRequest request) {
        return true;
    }

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        loggingService.logRequest(request, null);
    }

}