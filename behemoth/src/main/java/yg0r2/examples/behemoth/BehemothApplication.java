package yg0r2.examples.behemoth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableJpaRepositories(basePackages = "yg0r2.examples")
@EnableRedisHttpSession
@EntityScan(basePackages = "yg0r2.examples")
@SpringBootApplication(scanBasePackages = "yg0r2.examples"/*, exclude = {RedisAutoConfiguration.class}*/)
public class BehemothApplication {

    public static void main(String[] args) {
        SpringApplication.run(BehemothApplication.class, args);
    }

}
