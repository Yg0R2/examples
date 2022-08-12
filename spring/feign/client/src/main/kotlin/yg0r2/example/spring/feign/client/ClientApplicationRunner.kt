package yg0r2.example.spring.feign.client

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import yg0r2.example.spring.feign.client.client.DummyClient

@Component
class ClientApplicationRunner(
    private val dummyClient: DummyClient
): ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        while (true) {
            Thread.sleep(1000)

            try {
                LOGGER.info("${dummyClient.getValues()}")
            }
            catch (exception: Exception) {
                LOGGER.warn("Unexpected error during calling dummy client.", exception)
            }
        }
    }

    private companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(ClientApplicationRunner::class.java)
    }

}
