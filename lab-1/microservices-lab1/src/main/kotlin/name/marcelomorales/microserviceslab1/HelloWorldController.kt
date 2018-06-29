package name.marcelomorales.microserviceslab1

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HelloWorldController {

    @GetMapping("/")
    fun sayHello() = "hi"
}