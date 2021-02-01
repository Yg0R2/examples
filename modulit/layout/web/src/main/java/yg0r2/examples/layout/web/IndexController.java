package yg0r2.examples.layout.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@RequestMapping(path = "/")
public class IndexController {

    private static final String SESSION_ATTRIBUTE_USER_NAME = "user-name";

    @GetMapping
    public ModelAndView getIndex(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("index");

        modelAndView.addObject("userName", Objects.requireNonNullElse(session.getAttribute(SESSION_ATTRIBUTE_USER_NAME), "World"));

        return modelAndView;
    }

}
