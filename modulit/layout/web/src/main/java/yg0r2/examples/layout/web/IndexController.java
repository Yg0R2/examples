package yg0r2.examples.layout.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class IndexController {

    private static final String SESSION_ATTRIBUTE_USER_NAME = "user-name";

//    @GetMapping(path = "/")
    public ModelAndView getIndex(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("index");

        modelAndView.addObject("userName", Objects.requireNonNullElse(session.getAttribute(SESSION_ATTRIBUTE_USER_NAME), "World"));

        return modelAndView;
    }

    @RequestMapping(value = { "/", "/{x:[\\w\\-]+}", "/{x:^(?!api$).*$}/**/{y:[\\w\\-]+}" })
    public String getIndex(HttpServletRequest request) {
        return "/index.html";
    }

}
