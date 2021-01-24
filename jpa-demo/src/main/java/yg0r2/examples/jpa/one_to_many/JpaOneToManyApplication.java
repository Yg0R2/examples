package yg0r2.examples.jpa.one_to_many;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "yg0r2.examples.jpa.one_to_many.repository")
@EntityScan(basePackages = "yg0r2.examples.jpa.one_to_many.model")
@SpringBootApplication(scanBasePackages = "yg0r2.examples.jpa.one_to_many")
public class JpaOneToManyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaOneToManyApplication.class, args);
    }

}

