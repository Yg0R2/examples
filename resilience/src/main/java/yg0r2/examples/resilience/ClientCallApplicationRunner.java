package yg0r2.examples.resilience;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import yg0r2.examples.resilience.client.ServiceClient;

import java.util.Random;

@Component
public class ClientCallApplicationRunner implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientCallApplicationRunner.class);
    private static final Random RANDOM = new Random();

    @Autowired
    private ServiceClient serviceClient;

    @Override
    public void run(ApplicationArguments args)  {
        while (true) {
            try {
                Thread.sleep(RANDOM.nextInt(1000));

                serviceClient.get();
            }
            catch (Exception exception) {
                LOGGER.error(exception.getMessage(), exception);
            }
        }
    }

}
