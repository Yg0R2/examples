package yg0r2.example.spring.feign.application.web

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import yg0r2.example.spring.feign.application.exception.BadRequestException
import yg0r2.example.spring.feign.application.exception.NotFoundException
import javax.servlet.http.HttpServletResponse

@RestControllerAdvice
class ApplicationExceptionHandler {

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(response: HttpServletResponse) {
        response.status = 400
    }

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(response: HttpServletResponse) {
        response.status = 404
    }

    @ExceptionHandler(RuntimeException::class)
    fun handleRuntimeException(response: HttpServletResponse) {
        response.status = 500
    }

}
