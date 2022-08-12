package yg0r2.example.spring.feign.client

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class SpringFeignClientApplication

fun main(vararg args: String) {
    runApplication<SpringFeignClientApplication>(*args)
}
