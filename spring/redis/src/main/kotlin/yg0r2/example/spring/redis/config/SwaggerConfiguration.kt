package yg0r2.example.spring.redis.config

import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfiguration {

    @Bean
    fun openApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("endpoints")
            .pathsToMatch("/api/**")
            .build()
    }

}
