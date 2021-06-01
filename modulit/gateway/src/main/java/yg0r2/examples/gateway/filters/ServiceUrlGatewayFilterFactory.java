package yg0r2.examples.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class ServiceUrlGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> chain.filter(exchange)
            .then(Mono.fromRunnable(() -> {
                var response = exchange.getResponse();

                System.out.println("ServiceUrl Post Filter executed." + response);
            }));
    }

}
