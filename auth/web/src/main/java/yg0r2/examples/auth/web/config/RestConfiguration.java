package yg0r2.examples.auth.web.config;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;

@Configuration
public class RestConfiguration {

    @Bean
    @Profile(value = {"!default"})
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @Profile(value = {"default"})
    public RestTemplate restTemplateDefault() throws Exception {
        SSLContext sslContext = new SSLContextBuilder()
            .loadTrustMaterial(null, new TrustSelfSignedStrategy())
            .build();

        HttpClient httpClient = HttpClients.custom()
            .setSSLSocketFactory(new SSLConnectionSocketFactory(sslContext))
            .build();

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);

        return new RestTemplate(requestFactory);
    }

}
