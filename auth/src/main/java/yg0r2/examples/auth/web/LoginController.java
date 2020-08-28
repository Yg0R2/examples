package yg0r2.examples.auth.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping(path = "/sign-in")
    public String login(Model model) {
        return "login";
    }

}
