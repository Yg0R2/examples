package yg0r2.example.spring.feign.client.config

import feign.RequestInterceptor
import feign.codec.ErrorDecoder
import feign.okhttp.OkHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignConfiguration {

    @Bean
    fun client(): OkHttpClient =
        OkHttpClient()

    @Bean
    fun errorDecoder(): ErrorDecoder =
        CustomErrorDecoder()

    @Bean
    fun requestInterceptor(): RequestInterceptor =
        CustomRequestInterceptor()

}
