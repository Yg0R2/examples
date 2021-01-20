package yg0r2.examples.auth.client.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import yg0r2.examples.user.client.UserServiceClient;

@Configuration
@ConditionalOnProperty(name = "examples.behemoth", havingValue = "false", matchIfMissing = true)
public class UserServiceClientConfiguration {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${client.user.endpoint}")
    private String apiUrl;

    @Bean
    public UserServiceClient userServiceClient() {
        return new UserServiceClient(apiUrl, restTemplate);
    }

}
