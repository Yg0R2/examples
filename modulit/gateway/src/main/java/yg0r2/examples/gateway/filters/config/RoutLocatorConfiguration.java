package yg0r2.examples.gateway.filters.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yg0r2.examples.gateway.filters.LoggingGatewayFilterFactory;

@Configuration
public class RoutLocatorConfiguration {

    @Bean
    public RouteLocator auth(RouteLocatorBuilder routeLocatorBuilder, LoggingGatewayFilterFactory filterFactory) {
        return routeLocatorBuilder.routes()
            .route("auth_service_route", route ->
                route.path("/auth/**")
                    .filters(filter ->
                        filter.rewritePath("/auth(?<segment>/?.*)", "$\\{segment}")
                            .filter(filterFactory.apply(new LoggingGatewayFilterFactory.Config("My Custom Message", true, true)))
                    )
                    .uri("http://localhost:8010")
            )
            .build();
    }

}
