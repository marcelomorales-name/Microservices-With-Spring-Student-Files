package name.marcelomorales.microserviceslab1

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import javax.annotation.PostConstruct

@SpringBootApplication
class MicroServicesLab1Application(
        @Autowired val countryRepository : CountryRepository,
        @Autowired val cityRepository : CityRepository) {

    @PostConstruct
    fun init() {
        val chile = Country("CHL", "Chile", Continent.SOUTH_AMERICA)
        countryRepository.saveAll(listOf(chile))

        cityRepository.saveAll(listOf(City(null, "Santiago", chile, "RM", 7000000)))
    }
}


fun main(args: Array<String>) {
    runApplication<MicroServicesLab1Application>(*args)
}
