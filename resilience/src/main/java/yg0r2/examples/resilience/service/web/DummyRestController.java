package yg0r2.examples.resilience.service.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/dummy")
public class DummyRestController {

    @GetMapping
    public String greeting() {
        return UUID.randomUUID().toString();
    }

}
