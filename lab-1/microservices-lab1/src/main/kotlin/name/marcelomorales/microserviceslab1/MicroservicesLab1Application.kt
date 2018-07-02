package name.marcelomorales.microserviceslab1

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import javax.annotation.PostConstruct

@SpringBootApplication
class MicroservicesLab1Application(
        @Autowired val countryRepository : CountryRepository,
        @Autowired val cityRepository : CityRepository) {

    @PostConstruct
    fun init() {
        val country = Country("CHL", "Chile", Continent.SOUTH_AMERICA)
        countryRepository.saveAll(listOf(country))

        cityRepository.saveAll(listOf(City(null, "Santiago", country, "RM", 7000000)))
    }
}


fun main(args: Array<String>) {
    runApplication<MicroservicesLab1Application>(*args)
}
