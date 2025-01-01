package ma.commande.microservicewebapp.controller;

import ma.commande.microservicewebapp.model.Commande;
import ma.commande.microservicewebapp.model.Produit;
import ma.commande.microservicewebapp.service.ClientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Configuration
@Controller
public class ClientController {

    @Autowired
    private ClientProxy clientProxy;

    @GetMapping(value = "/")
    public String dashbord(Model model) {
        model.addAttribute("produits", clientProxy.getAllProduits());
        model.addAttribute("produit", new Produit());
        model.addAttribute("name","Historique des commandes");
        model.addAttribute("commandes", clientProxy.getHistoriqueCommandes());
        model.addAttribute("commande", new Commande());
        model.addAttribute(("showcommande"), false);
        model.addAttribute(("showproduit"), true);
        return "dashboard";
    }


    @GetMapping(value = "/editProduit/{id}")
    public String editProduit(@PathVariable Long id, Model model) {
        Produit produit = clientProxy.getProduitById(id);
        model.addAttribute("produits", clientProxy.getAllProduits());
        model.addAttribute("commandes", clientProxy.getHistoriqueCommandes());
        model.addAttribute("name","Historique des commandes");
        model.addAttribute("commande", new Commande());
        model.addAttribute(("showcommande"), false);
        model.addAttribute(("showproduit"), true);
        model.addAttribute("produit", produit);
        return "dashboard";
    }
    @GetMapping(value = "/editCommande/{id}")
    public String editCommande(@PathVariable Long id, Model model) {
        Commande commande = clientProxy.getCommandeById(id);
        model.addAttribute("produits", clientProxy.getAllProduits());
        model.addAttribute("commandes", clientProxy.getHistoriqueCommandes());
        model.addAttribute("name","Historique des commandes");
        model.addAttribute("commande",commande);
        model.addAttribute(("showcommande"), true);
        model.addAttribute(("showproduit"), false);
        model.addAttribute("produit", new Produit());
        return "dashboard";
    }

    @GetMapping(value = "/details/{id}")
    public String voirCommande(@PathVariable Long id, Model model) {
        List<Commande> commandes = clientProxy.getCommandesByProduitId(id);
        model.addAttribute("produits", clientProxy.getAllProduits());
        model.addAttribute("produit", new Produit());
        model.addAttribute("name","Commande du "+clientProxy.getProduitById(id).getNom());
        model.addAttribute("commande", new Commande());
        model.addAttribute(("showcommande"), false);
        model.addAttribute(("showproduit"), false);
        model.addAttribute("commandes", commandes);
        return "dashboard";
    }

    @PostMapping(value = "/saveCommande")
    public String saveCommande(@ModelAttribute Commande commande) {
        clientProxy.saveCommande(commande);
        return "redirect:/";
    }

    @PostMapping(value = "/saveProduit")
    public String saveProduit(@ModelAttribute Produit produit) {
        clientProxy.saveProduit(produit);
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


}
