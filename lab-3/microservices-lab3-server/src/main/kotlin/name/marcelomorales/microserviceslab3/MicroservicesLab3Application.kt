package name.marcelomorales.microserviceslab3

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
class MicroservicesLab3Application

fun main(args: Array<String>) {
    runApplication<MicroservicesLab3Application>(*args)
}
