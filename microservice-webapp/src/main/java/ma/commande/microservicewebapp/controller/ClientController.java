package ma.commande.microservicewebapp.controller;

import ma.commande.microservicewebapp.model.Commande;
import ma.commande.microservicewebapp.model.Produit;
import ma.commande.microservicewebapp.service.ClientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Configuration
@Controller
public class ClientController {

    @Autowired
    private ClientProxy clientProxy;

    @GetMapping(value = "/")
    public String dashbord(Model model) {
        model.addAttribute("produits", clientProxy.getAllProduits());
        model.addAttribute("produit", new Produit());
        model.addAttribute("commandes", clientProxy.getAllCommandes());
        model.addAttribute("commande", new Commande());
        model.addAttribute("idproduit", clientProxy.getProduitById(1L).getId());
        model.addAttribute("nomproduit", clientProxy.getProduitById(1L).getNom());
        model.addAttribute("prixproduit", clientProxy.getProduitById(1L).getPrix());
        return "dashboard";
    }

    @PostMapping(value = "/saveProduit")
    public String saveProduit(@ModelAttribute Produit produit) {
        System.out.println(produit);
        clientProxy.saveProduit(produit);
        return "redirect:/";
    }
    @GetMapping(value = "/passerCommande/{id}")
    public void passerCommande(@PathVariable Long id , Model model) {
        Produit prod = clientProxy.getProduitById(id);
        model.addAttribute("idproduit",prod.getId());
        model.addAttribute("nomproduit",prod.getNom());
        model.addAttribute("prixproduit",prod.getPrix());
    }
    @PostMapping(value = "/saveCommande")
    public String saveCommande(@RequestBody Commande commande) {
        clientProxy.saveCommande(commande);
        return "redirect:/dashboard";
    }

    @GetMapping(value = "/deleteProduit/{id}")
    public String deleteProduit(@PathVariable Long id) {
        clientProxy.deleteProduit(id);
        return "redirect:/";
    }

    @GetMapping(value = "/deleteCommande/{id}")
    public String deleteCommande(@PathVariable Long id) {
        clientProxy.deleteCommande(id);
        return "redirect:/";
    }

}
