package yg0r2.example.spring.feign.client.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import yg0r2.example.spring.feign.client.config.FeignConfiguration

@FeignClient(
    configuration = [FeignConfiguration::class],
    name = "dummy-client",
    url = "\${dummy-service.url}"
)
interface DummyClient {

    @GetMapping("/api/feign/instant")
    fun getInstantValues(): List<String>

}