package name.marcelomorales.microserviceslab1

import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import javax.persistence.*


@Entity
@Table(name = "city")
data class City(
        @Id @GeneratedValue() val id : Long?,
        val name : String,
        @ManyToOne(optional = false) @JoinColumn(name = "country_code") val country: Country,
        val district : String,
        val population : Long
)

@RepositoryRestResource(path = "/cities")
interface CityRepository : CrudRepository<City, Long>
