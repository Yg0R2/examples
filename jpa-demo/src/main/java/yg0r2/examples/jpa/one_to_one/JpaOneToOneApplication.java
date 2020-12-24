package yg0r2.examples.jpa.one_to_one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "yg0r2.examples.jpa.one_to_one.repository")
@EntityScan(basePackages = "yg0r2.examples.jpa.one_to_one.model")
@SpringBootApplication(scanBasePackages = "yg0r2.examples.jpa.one_to_one")
public class JpaOneToOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaOneToOneApplication.class, args);
    }

}

