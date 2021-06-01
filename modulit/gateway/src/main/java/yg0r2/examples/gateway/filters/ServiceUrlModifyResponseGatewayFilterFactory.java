package yg0r2.examples.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.rewrite.MessageBodyDecoder;
import org.springframework.cloud.gateway.filter.factory.rewrite.MessageBodyEncoder;
import org.springframework.cloud.gateway.filter.factory.rewrite.ModifyResponseBodyGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.http.codec.ServerCodecConfigurer;
import reactor.core.publisher.Mono;
import yg0r2.examples.gateway.config.model.MapRoutDefinitionConfig;

import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServiceUrlModifyResponseGatewayFilterFactory extends ModifyResponseBodyGatewayFilterFactory {

    private static final Pattern SERVICE_URL_PATTERN = Pattern.compile("((?<serviceUrl>http://(?<serviceFullName>(?<serviceName>.*?)-service))/)");

    private final Map<String, RouteDefinition> routDefinitionMap;

    public ServiceUrlModifyResponseGatewayFilterFactory(ServerCodecConfigurer codecConfigurer, Set<MessageBodyDecoder> messageBodyDecoders,
        Set<MessageBodyEncoder> messageBodyEncoders, MapRoutDefinitionConfig mapRoutDefinitionConfig) {

        super(codecConfigurer.getReaders(), messageBodyDecoders, messageBodyEncoders);

        routDefinitionMap = mapRoutDefinitionConfig.getRoutes();
    }

    @Override
    public GatewayFilter apply(Config config) {
        config.setInClass(String.class);
        config.setOutClass(String.class);
        config.setRewriteFunction((exchange, body) -> Mono.justOrEmpty(replaceServiceUrls((String) body)));

        ModifyResponseGatewayFilter gatewayFilter = new ModifyResponseGatewayFilter(config);

        gatewayFilter.setFactory(this);

        return gatewayFilter;
    }

    private String replaceServiceUrls(String body) {
        if ((body == null) || body.isBlank()) {
            return body;
        }

        StringBuilder sb = new StringBuilder();

        int end = 0;

        Matcher matcher = SERVICE_URL_PATTERN.matcher(body);

        while (matcher.find()) {
            String serviceFullName = matcher.group("serviceFullName");

            if (routDefinitionMap.containsKey(serviceFullName + "-route")) {
                String serviceUrl = matcher.group("serviceUrl");

                matcher.appendReplacement(sb, serviceUrl + ".localhost/");
            }
            else {
                String serviceName = matcher.group("serviceName");

                matcher.appendReplacement(sb, "http://localhost/" + serviceName + "/");
            }

            end = matcher.end();
        }

        if ((sb.length() == 0) || (end == 0)) {
            return body;
        }

        sb.append(body.substring(end));

        return sb.toString();
    }

}
