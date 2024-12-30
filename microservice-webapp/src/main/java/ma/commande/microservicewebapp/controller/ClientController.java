package ma.commande.microservicewebapp.controller;

import ma.commande.microservicewebapp.model.Commande;
import ma.commande.microservicewebapp.model.Produit;
import ma.commande.microservicewebapp.service.ClientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller(value = "/dashbord")
public class ClientController {

    @Autowired
    private ClientProxy clientProxy;

    @GetMapping(value = "/")
    public String dashbord() {
        return "dashbord";
    }

    @PostMapping(value = "/saveProduit")
    public String saveProduit(@RequestBody Produit produit) {
        return "redirect:/dashbord";
    }

    @PostMapping(value = "/saveCommande")
    public String saveCommande(@RequestBody Commande commande) {
        return "redirect:/dashbord";
    }

    @PostMapping(value = "/deleteProduit/{id}")
    public String deleteProduit(@PathVariable Long id) {
        return "redirect:/dashbord";
    }

    @PostMapping(value = "/deleteCommande/{id}")
    public String deleteCommande(@PathVariable Long id) {
        return "redirect:/dashbord";
    }

}
