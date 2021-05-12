package yg0r2.examples.core;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
public class RedisSessionStoreConfiguration {

    @ConditionalOnProperty(name = "spring.session.store-type", matchIfMissing = true, havingValue = "false")
    @Configuration
    @EnableAutoConfiguration(exclude = {RedisAutoConfiguration.class})
    public static class DisableRedisAutoConfiguration {
    }

    @ConditionalOnProperty(name = "spring.session.store-type", havingValue = "redis")
    @Configuration
    @EnableRedisHttpSession
    public static class EnableRedisAutoConfiguration {
    }

}