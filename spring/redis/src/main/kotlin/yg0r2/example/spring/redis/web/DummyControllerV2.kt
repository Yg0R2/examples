package yg0r2.example.spring.redis.web

import io.swagger.v3.oas.annotations.Parameter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import yg0r2.example.spring.redis.service.DummyV2Service

@RequestMapping("/api/dummy/v2")
@RestController
class DummyControllerV2(
    private val dummyService: DummyV2Service
) {

    @GetMapping("/{id}")
    fun get(
        @Parameter(example = "0") @PathVariable(required = false) id: Long = 0,
        @RequestParam(defaultValue = "false") cached: Boolean = false
    ): String =
        if (cached) {
            dummyService.getCached(id, "V2")
        }
        else {
            dummyService.get(id, "V2")
        }

}
