package yg0r2.example.spring.feign.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringFeignApplication

fun main(vararg args: String) {
    runApplication<SpringFeignApplication>(*args)
}
