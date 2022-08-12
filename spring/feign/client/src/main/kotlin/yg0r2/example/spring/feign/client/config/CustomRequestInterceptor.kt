package yg0r2.example.spring.feign.client.config

import feign.RequestInterceptor
import feign.RequestTemplate
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class CustomRequestInterceptor: RequestInterceptor {

    override fun apply(template: RequestTemplate) {
        LOGGER.info("intercept request")

        template.header("x-custom-header", "custom header value")
    }

    private companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(CustomRequestInterceptor::class.java)
    }

}
