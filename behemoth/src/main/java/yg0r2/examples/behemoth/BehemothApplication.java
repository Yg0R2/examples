package yg0r2.examples.behemoth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;

@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
public class BehemothApplication {

    public static void main(String[] args) {
        SpringApplication.run(BehemothApplication.class, args);
    }

}
