package yg0r2.example.spring.feign.application.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import yg0r2.example.spring.feign.application.exception.BadRequestException
import yg0r2.example.spring.feign.application.exception.NotFoundException

@RequestMapping("/api/feign")
@RestController
class DummyRestController {

    @GetMapping("/instant")
    fun getInstantValues(): List<String> =
        listOf(
            "value - 1",
            "value - 2"
        )

    @GetMapping("/slow")
    fun getSlowValues(): List<String> {
        Thread.sleep(1000)

        return listOf(
            "value - 1",
            "value - 2"
        )
    }

    @GetMapping("/status")
    fun getStatus(
        @RequestParam code: Int
    ): String =
        when (code) {
            200 -> "OK"
            400 -> throw BadRequestException()
            404 -> throw NotFoundException()
            else -> throw RuntimeException()
        }

}
