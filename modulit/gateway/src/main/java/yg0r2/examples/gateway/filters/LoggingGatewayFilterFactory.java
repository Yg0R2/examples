package yg0r2.examples.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class LoggingGatewayFilterFactory extends AbstractGatewayFilterFactory<LoggingGatewayFilterFactory.Config> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingGatewayFilterFactory.class);
    private static final int GATEWAY_FILTER_ORDER = -1;

    public LoggingGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return new OrderedGatewayFilter((exchange, chain) -> {
            if (config.isPreLogger()) {
                LOGGER.info("Pre GatewayFilter logging: {}", config.getBaseMessage());
            }

            return chain.filter(exchange)
                .then(Mono.fromRunnable(() -> {
                    if (config.isPostLogger()) {
                        LOGGER.info("Post GatewayFilter logging: {}", config.getBaseMessage());
                    }
                }));
        }, GATEWAY_FILTER_ORDER);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return List.of("baseMessage", "preLogger", "postLogger");
    }

    public static class Config {

        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;

        public Config(String baseMessage, boolean preLogger, boolean postLogger) {
            this.baseMessage = baseMessage;
            this.preLogger = preLogger;
            this.postLogger = postLogger;
        }

        public String getBaseMessage() {
            return baseMessage;
        }

        public void setBaseMessage(String baseMessage) {
            this.baseMessage = baseMessage;
        }

        public boolean isPreLogger() {
            return preLogger;
        }

        public void setPreLogger(boolean preLogger) {
            this.preLogger = preLogger;
        }

        public boolean isPostLogger() {
            return postLogger;
        }

        public void setPostLogger(boolean postLogger) {
            this.postLogger = postLogger;
        }

    }

}
