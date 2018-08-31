package name.marcelomorales.microserviceslab3client

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LuckyController (@Value("\${lucky-word}") var lucky : String) {

    @GetMapping("/lucky-word") fun sayIt() = lucky
}