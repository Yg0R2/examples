package yg0r2.example.spring.redis.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class DummyV2Service {

    fun get(id: Long, scope: String): String {
        LOGGER.info("Get not cached value.")

        return "$scope-value-$id"
    }

    @Cacheable("dummy-cache")
    fun getCached(id: Long, scope: String): String {
        return get(id, scope)
    }

    private companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(DummyV2Service::class.java)
    }

}
