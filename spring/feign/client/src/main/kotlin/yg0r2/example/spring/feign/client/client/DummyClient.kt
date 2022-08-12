package yg0r2.example.spring.feign.client.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(
    name = "dummy-client",
    url = "\${dummy-service.url}"
)
interface DummyClient {

    @GetMapping("/api/dummy")
    fun getValues(): List<String>

}
