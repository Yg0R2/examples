package yg0r2.examples.resilience.client.config.model;

import com.lgi.commons.resilience4j.config.ResilienceTentacleConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import yg0r2.examples.resilience.client.decorator.model.ResilienceConfig;

@Configuration
@ConfigurationProperties(prefix = "service.client")
public class ClientConfig {

    private ResilienceConfig resilience;
    private String url;

    public ResilienceConfig getResilience() {
        return resilience;
    }

    public void setResilience(ResilienceConfig resilience) {
        this.resilience = resilience;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
