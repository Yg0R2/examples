package yg0r2.example.spring.redis.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class DummyService {

    fun get(id: Long): String {
        LOGGER.info("Get not cached value.")

        return "value-$id"
    }

    @Cacheable("dummy-cache")
    fun getCached(id: Long): String {
        return get(id)
    }

    private companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(DummyService::class.java)
    }

}
