package yg0r2.examples.auth.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class UserServiceClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${client.user.endpoint}")
    private String userServiceUrl;

    public ResponseEntity<Boolean> isExist(String userName, String password) {
        String url = UriComponentsBuilder.fromHttpUrl(userServiceUrl)
            .queryParam("userName", userName)
            .queryParam("password", password)
            .toUriString();

        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), Boolean.class);
    }

}
