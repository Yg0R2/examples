package yg0r2.examples.gateway.config.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Objects;

/**
 * Required because: https://github.com/spring-cloud/spring-cloud-gateway/issues/831
 */
@Configuration
@ConfigurationProperties(prefix = "spring.cloud.gateway")
public class MapRoutDefinitionConfig {

    @Autowired
    private RouteDefinitionWriter routeDefinitionWriter;

    private Map<String, RouteDefinition> routes;

    public Map<String, RouteDefinition> getRoutes() {
        return routes;
    }

    public void setRoutes(Map<String, RouteDefinition> routes) {
        this.routes = Map.copyOf(routes);
    }

    @PostConstruct
    public void init() {
        Objects.requireNonNullElse(routes, Map.<String, RouteDefinition>of()).entrySet().stream()
            .map(MapRoutDefinitionConfig::createMono)
            .map(routeDefinitionWriter::save)
            .forEach(Mono::subscribe);
    }

    private static Mono<RouteDefinition> createMono(Map.Entry<String, RouteDefinition> entry) {
        return Mono.just(entry.getValue())
            .map(route -> {
                route.setId(entry.getKey());

                return route;
            });
    }

}
