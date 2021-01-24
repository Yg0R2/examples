package yg0r2.examples.user.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import yg0r2.examples.user.api.client.UserServiceClient;

import java.util.Objects;

@Component
@ConditionalOnMissingClass(value = { "yg0r2.examples.user.behemoth.client.BehemothUserServiceClient" })
public class DefaultUserServiceClient implements UserServiceClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${client.user.endpoint}")
    private String apiUrl;

    @Override
    public boolean isExist(String userName, String password) {
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
            .queryParam("userName", userName)
            .queryParam("password", password)
            .toUriString();

        ResponseEntity<Boolean> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), Boolean.class);

        return (response.getStatusCode() == HttpStatus.OK) && Objects.equals(response.getBody(), true);
    }

}
