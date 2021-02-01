package yg0r2.examples.layout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
@SpringBootApplication
public class LayoutApplication {

    public static void main(String[] args) {
        SpringApplication.run(LayoutApplication.class, args);
    }

}
