package yg0r2.examples.gateway.filters.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;
import yg0r2.examples.gateway.filters.LoggingGlobalPreFilter;

@Configuration
public class LoggingGlobalFilterConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingGlobalFilterConfiguration.class);

    @Bean
    public GlobalFilter loggingGlobalPreFilter() {
        return new LoggingGlobalPreFilter();
    }

    @Bean
    public GlobalFilter loggingGlobalPostFilter() {
        return (exchange, chain) ->
            chain.filter(exchange)
                .then(Mono.fromRunnable(() -> LOGGER.info("Global Post Filter executed.")));
    }

}
