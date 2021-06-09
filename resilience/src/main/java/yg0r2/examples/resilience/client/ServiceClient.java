package yg0r2.examples.resilience.client;

import com.lgi.commons.resilience4j.decorator.ClientResilienceDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import yg0r2.examples.resilience.client.config.model.ClientConfig;

import java.util.function.Supplier;

@Component
public class ServiceClient {

    @Autowired
    private ClientConfig clientConfig;
    @Autowired
    private RestTemplate restTemplate;

    public String get() {
        Supplier<String> clientCallSupplier = () -> restTemplate.getForObject(clientConfig.getUrl(), String.class);

        var resilienceDecorator = new ClientResilienceDecorator(null);//clientConfig.getResilience());

        return resilienceDecorator.ofSupplier(clientCallSupplier)
            .withCircuitBreaker()
            .decorate()
            .get();
    }

}
