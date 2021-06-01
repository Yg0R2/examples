package yg0r2.examples.gateway.filters.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.factory.rewrite.MessageBodyDecoder;
import org.springframework.cloud.gateway.filter.factory.rewrite.MessageBodyEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import yg0r2.examples.gateway.config.model.MapRoutDefinitionConfig;
import yg0r2.examples.gateway.filters.ServiceUrlModifyResponseGatewayFilterFactory;

import java.util.Set;

@Configuration
public class GlobalFilterFactoryConfiguration {

    @Value("${spring.cloud.max-in-memory-size:-262144}")
    private int maxInMemorySize;

    @Bean
    public ServiceUrlModifyResponseGatewayFilterFactory serviceUrlModifyResponseBodyGatewayFilterFactory(ServerCodecConfigurer codecConfigurer,
        Set<MessageBodyDecoder> bodyDecoders, Set<MessageBodyEncoder> bodyEncoders, MapRoutDefinitionConfig mapRoutDefinitionConfig) {

        codecConfigurer.defaultCodecs()
            .maxInMemorySize(maxInMemorySize);

        return new ServiceUrlModifyResponseGatewayFilterFactory(codecConfigurer, bodyDecoders, bodyEncoders, mapRoutDefinitionConfig);
    }

}
