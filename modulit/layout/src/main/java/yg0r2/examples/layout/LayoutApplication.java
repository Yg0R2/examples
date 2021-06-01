package yg0r2.examples.layout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"yg0r2.examples.core", "yg0r2.examples.layout"})
public class LayoutApplication {

    public static void main(String[] args) {
        SpringApplication.run(LayoutApplication.class, args);
    }

}
