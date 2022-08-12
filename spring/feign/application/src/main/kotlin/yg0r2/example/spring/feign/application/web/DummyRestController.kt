package yg0r2.example.spring.feign.application.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/dummy")
@RestController
class DummyRestController {

    @GetMapping
    fun getValues(): List<String> =
        listOf(
            "value - 1",
            "value - 2"
        )

}
