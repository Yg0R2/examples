package yg0r2.examples.user.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class DefaultUserServiceClient implements UserServiceClient {

    private final String apiUrl;
    private final RestTemplate restTemplate;

    public DefaultUserServiceClient(String apiUrl, RestTemplate restTemplate) {
        this.apiUrl = apiUrl;
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<Boolean> isExist(String userName, String password) {
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
            .queryParam("userName", userName)
            .queryParam("password", password)
            .toUriString();

        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), Boolean.class);
    }

}
