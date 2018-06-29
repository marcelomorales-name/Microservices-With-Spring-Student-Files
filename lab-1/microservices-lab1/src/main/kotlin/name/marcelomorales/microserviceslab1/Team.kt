package name.marcelomorales.microserviceslab1

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "MY_TEAM")
data class Team(
        @Id @GeneratedValue(strategy = IDENTITY) var id: Long?,
        var name: String,
        var mascot: String?)


@RestController
class TeamController(@Autowired val teamRepository: TeamRepository) {

    @GetMapping("/teams")
    fun getTeams(): Iterable<Team> = teamRepository.findAll()
}

interface TeamRepository : CrudRepository<Team, Long>