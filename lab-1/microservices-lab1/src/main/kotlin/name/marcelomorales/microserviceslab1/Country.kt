package name.marcelomorales.microserviceslab1

import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import javax.persistence.*

/*

marcelo=> \d countrylanguage
               Table "public.countrylanguage"
   Column    |     Type     | Collation | Nullable | Default
-------------+--------------+-----------+----------+---------
 countrycode | character(3) |           | not null |
 language    | text         |           | not null |
 isofficial  | boolean      |           | not null |
 percentage  | real         |           | not null |
Indexes:
    "countrylanguage_pkey" PRIMARY KEY, btree (countrycode, language)
Foreign-key constraints:
    "countrylanguage_countrycode_fkey" FOREIGN KEY (countrycode) REFERENCES country(code)

 */

enum class Continent(val realName: String) {
    AFRICA("Africa"),
    ANTARTICA("Antarctica"),
    ASIA("Asia"),
    EUROPE("Europe"),
    NORTH_AMERICA("North America"),
    OCEANIA("Oceania"),
    SOUTH_AMERICA("South America")
}

@Converter(autoApply = true)
class ContinentConverter : AttributeConverter<Continent, String> {
    override fun convertToDatabaseColumn(attribute: Continent?): String? = attribute?.realName

    override fun convertToEntityAttribute(dbData: String?): Continent =
            Continent.values().first { it.realName == dbData }
}

@Entity
@Table(name = "country")
data class Country(
        @Id @Column(length = 3) val code : String,
        val name : String,
        @Convert(converter = ContinentConverter::class) val continent : Continent


//Foreign-key constraints:
//    "country_capital_fkey" FOREIGN KEY (capital) REFERENCES city(id)
//Referenced by:
//    TABLE "countrylanguage" CONSTRAINT "countrylanguage_countrycode_fkey" FOREIGN KEY (countrycode) REFERENCES country(code)
//region         | text          |           | not null |
//surfacearea    | real          |           | not null |
//indepyear      | smallint      |           |          |
//population     | integer       |           | not null |
//lifeexpectancy | real          |           |          |
//gnp            | numeric(10,2) |           |          |
//gnpold         | numeric(10,2) |           |          |
//localname      | text          |           | not null |
//governmentform | text          |           | not null |
//headofstate    | text          |           |          |
//capital        | integer       |           |          |
//code2          | character(2)  |           | not null |
)

@RepositoryRestResource(path = "/countries")
interface CountryRepository : CrudRepository<Country, String>
