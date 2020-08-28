package yg0r2.examples.auth.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/other")
@RestController
public class OtherRestController {

    @GetMapping
    public String get() {
        return "Hello from the Other controller.";
    }

}
