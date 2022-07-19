package yg0r2.example.spring.jpa;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yg0r2.example.spring.jpa.dao.model.ExampleEntity;

import java.util.function.Supplier;

@Service
public class LoggingHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingHelper.class);

    @Autowired
    private ObjectMapper objectMapper;

    public void logEntityCreation(Supplier<ExampleEntity> entitySupplier) throws JsonProcessingException {
        LOGGER.info("Created: {}", objectMapper.writeValueAsString(entitySupplier.get()));
    }

}
