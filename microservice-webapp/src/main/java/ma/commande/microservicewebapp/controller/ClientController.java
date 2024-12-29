package ma.commande.microservicewebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "/dashbord")
public class ClientController {

    @GetMapping(value = "/")
    public String dashbord() {
        return "dashbord";
    }
}
