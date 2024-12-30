package ma.commande.microservicewebapp.controller;

import ma.commande.microservicewebapp.model.Commande;
import ma.commande.microservicewebapp.model.Produit;
import ma.commande.microservicewebapp.service.ClientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Configuration
@Controller
public class ClientController {

    @Autowired
    private ClientProxy clientProxy;

    @GetMapping(value = {"/dashboard","/"})
    public String dashbord(Model model) {
        model.addAttribute("produits", clientProxy.getAllProduits());
        model.addAttribute("produit", new Produit());
        model.addAttribute("commandes", clientProxy.getAllCommandes());
        return "dashboard";
    }

    @PostMapping(value = "/saveProduit")
    public String saveProduit(@RequestBody Produit produit) {
        clientProxy.saveProduit(produit);
        return "redirect:/dashboard";
    }

    @PostMapping(value = "/saveCommande")
    public String saveCommande(@RequestBody Commande commande) {
        return "redirect:/dashboard";
    }

    @PostMapping(value = "/deleteProduit/{id}")
    public String deleteProduit(@PathVariable Long id) {
        clientProxy.deleteProduit(id);
        return "redirect:/dashboard";
    }

    @PostMapping(value = "/deleteCommande/{id}")
    public String deleteCommande(@PathVariable Long id) {
        return "redirect:/dashboard";
    }

}
