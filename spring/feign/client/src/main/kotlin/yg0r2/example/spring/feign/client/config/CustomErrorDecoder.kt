package yg0r2.example.spring.feign.client.config

import feign.Response
import feign.codec.ErrorDecoder
import java.lang.Exception

class CustomErrorDecoder : ErrorDecoder {

    override fun decode(methodKey: String, response: Response): Exception =
        when (response.status()) {
            400 -> BadRequestException()
            404 -> NotFoundException()
            else -> InternalServiceException()
        }

    class BadRequestException : RuntimeException("Bad request")

    class InternalServiceException : RuntimeException("Internal service")

    class NotFoundException : RuntimeException("Not found")

}
