package yg0r2.example.spring.redis

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ActuatorApplication

fun main(vararg args: String) {
    runApplication<ActuatorApplication>(*args)
}
