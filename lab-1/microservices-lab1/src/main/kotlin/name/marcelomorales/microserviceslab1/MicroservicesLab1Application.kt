package name.marcelomorales.microserviceslab1

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import javax.annotation.PostConstruct

@SpringBootApplication
class MicroservicesLab1Application(@Autowired val repo : TeamRepository) {

    @PostConstruct
    fun init() = repo.saveAll(listOf(
            Team(null, "Bolivar", null),
            Team(null, "The Strongest", "Tiger")))
}


fun main(args: Array<String>) {
    runApplication<MicroservicesLab1Application>(*args)
}
