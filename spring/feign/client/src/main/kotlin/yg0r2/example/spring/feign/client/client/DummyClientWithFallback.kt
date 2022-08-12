package yg0r2.example.spring.feign.client.client

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import yg0r2.example.spring.feign.client.config.FeignConfiguration

@FeignClient(
    configuration = [FeignConfiguration::class],
    fallback = DummyClientFallback::class,
    name = "dummy-client-with-fallback",
    url = "\${dummy-service.url}"
)
interface DummyClientWithFallback {

    @GetMapping("/api/feign/slow")
    fun getSlowValues(): List<String>


}

@Component
class DummyClientFallback : DummyClientWithFallback {

    override fun getSlowValues(): List<String> {
        LOGGER.warn("Client call failed, executing fallback...")

        return listOf()
    }

    private companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(DummyClientFallback::class.java)
    }

}
