package yg0r2.example.spring.feign.client

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import yg0r2.example.spring.feign.client.client.DummyClient
import yg0r2.example.spring.feign.client.client.DummyClientWithErrorHandler
import yg0r2.example.spring.feign.client.client.DummyClientWithFallback
import yg0r2.example.spring.feign.client.config.CustomErrorDecoder

@Component
class ClientApplicationRunner(
    private val dummyClient: DummyClient,
    private val dummyClientWithErrorHandler: DummyClientWithErrorHandler,
    private val dummyClientWithFallback: DummyClientWithFallback
): ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        while (true) {
            Thread.sleep(1000)

            try {
                LOGGER.info("instant: ${dummyClient.getInstantValues()}")

                LOGGER.info("slow: ${dummyClientWithFallback.getSlowValues()}")

                listOf(200, 400, 404, 500)
                    .forEach {
                        try {
                            LOGGER.info("status($it): ${dummyClientWithErrorHandler.getStatus(it)}")
                        } catch (exception: Exception) {
                            if (exception.cause is CustomErrorDecoder.BadRequestException
                                || exception.cause is CustomErrorDecoder.NotFoundException
                                || exception.cause is CustomErrorDecoder.InternalServiceException
                            ) {
                                LOGGER.info("status($it): ${exception.cause?.message}")
                            }
                            else {
                                throw exception
                            }
                        }
                    }
            }
            catch (exception: Exception) {
                LOGGER.error("Unexpected error during calling dummy client.", exception)
            }
        }
    }

    private companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(ClientApplicationRunner::class.java)
    }

}
