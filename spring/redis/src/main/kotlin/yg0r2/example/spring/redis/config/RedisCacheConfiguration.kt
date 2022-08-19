package yg0r2.example.spring.redis.config

import org.springframework.cache.CacheManager
import org.springframework.cache.concurrent.ConcurrentMapCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RedisCacheConfiguration {

    @Bean
    fun cacheManager(): CacheManager =
        ConcurrentMapCacheManager()

}
