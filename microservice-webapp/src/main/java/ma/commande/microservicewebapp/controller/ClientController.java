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

    private boolean showHistory = false;

    @GetMapping(value = "/")
    public String dashbord(Model model) {
        model.addAttribute("produits", clientProxy.getAllProduits());
        model.addAttribute("produit", new Produit());
        model.addAttribute("commandes", clientProxy.getHistoriqueCommandes());
        model.addAttribute("commande", new Commande());
        model.addAttribute("showHistory", false);
        return "dashboard";
    }

    @PostMapping(value = "/saveProduit")
    public String saveProduit(@ModelAttribute Produit produit) {
        clientProxy.saveProduit(produit);
        return "redirect:/";
    }

    @GetMapping(value = "/passerCommande/{id}")
    public String passerCommande(@PathVariable Long id, Model model) {
        Produit prod = clientProxy.getProduitById(id);
        Commande commande = new Commande();
        commande.setIdProduit(prod.getId());
        model.addAttribute("commande", commande);
        model.addAttribute("selectedProduit", prod);
        model.addAttribute("commandes", clientProxy.getCommandesByProduitId(id));
        return "dashboard";
    }

    @PostMapping(value = "/saveCommande")
    public String saveCommande(@ModelAttribute Commande commande) {
        clientProxy.saveCommande(commande);
        return "redirect:/";
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

    @GetMapping("/toggleHistory")
    public String toggleHistory(@RequestParam(name = "showHistory", required = false) Boolean showHistory, Model model) {
        model.addAttribute("produits", clientProxy.getAllProduits());
        model.addAttribute("produit", new Produit());
        model.addAttribute("commandes", clientProxy.getAllCommandes());
        model.addAttribute("commande", new Commande());
        model.addAttribute("showHistory", showHistory != null ? !showHistory : true);
        return "dashboard";
    }

}
