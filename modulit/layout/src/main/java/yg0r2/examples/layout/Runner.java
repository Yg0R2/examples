package yg0r2.examples.layout;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private TestConfiguration testConfiguration;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(testConfiguration.getMyMap());
    }

    @Configuration
    @ConfigurationProperties(prefix = "test", ignoreUnknownFields = false)
    public static class TestConfiguration {

        @Autowired
        private ObjectMapper objectMapper;

        private Map<String, String> myMap;

        public Map<String, String> getMyMap() {
            return myMap;
        }

        public void setMyMap(String myMap) throws JsonProcessingException {
            this.myMap = objectMapper.readValue(myMap, Map.class);
        }

    }

}
