package yg0r2.examples.user.web.rest;

import yg0r2.examples.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping(path = "/api/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/exists", params = {"userName", "password"})
    public boolean isExist(@RequestParam @NotBlank String userName, @RequestParam @NotBlank String password) {
        return userService.isExist(userName, password);
    }

}
