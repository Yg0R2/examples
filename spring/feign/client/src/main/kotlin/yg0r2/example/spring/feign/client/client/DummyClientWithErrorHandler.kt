package yg0r2.example.spring.feign.client.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import yg0r2.example.spring.feign.client.config.FeignConfiguration

@FeignClient(
    configuration = [FeignConfiguration::class],
    name = "dummy-client-with-error-handler",
    url = "\${dummy-service.url}"
)
interface DummyClientWithErrorHandler {

    @GetMapping("/api/feign/status")
    fun getStatus(
        @RequestParam code: Int
    ): String

}