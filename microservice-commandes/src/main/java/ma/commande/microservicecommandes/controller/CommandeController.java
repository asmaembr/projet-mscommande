package ma.commande.microservicecommandes.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.commande.microservicecommandes.config.PropertiesConfig;
import ma.commande.microservicecommandes.model.Commande;
import ma.commande.microservicecommandes.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Configuration
@RestController
public class CommandeController {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private PropertiesConfig propertiesConfig;

    // Circuit Breaker Fallback methode pour /commandes et /historique
    public List<Commande> fallbackForList(Exception t) {
        System.out.println("\u001B[1;31mCircuit Breaker triggered due to: " + t.getMessage() + "\u001B[0m");
        return List.of();
    }

    // Circuit Breaker Fallback methode pour /commande/{id} et /commande (Post) et (Get)
    public Commande fallbackForSingleCommande(Exception t) {
        System.out.println("\u001B[1;31mCircuit Breaker triggered due to: " + t.getMessage() + "\u001B[0m");
        return null;
    }

    // Circuit Breaker Fallback methode pour /commande/{id} (Delete)
    public void fallbackForVoid(Exception t) {
        System.out.println("\u001B[1;31mCircuit Breaker triggered due to: " + t.getMessage() + "\u001B[0m");
    }

    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "fallbackForList")
    @GetMapping("/historique")
    public List<Commande> getCommandesDerniersJours() throws Exception {
        LocalDate dateLimite = LocalDate.now().minusDays(propertiesConfig.getCommandesLast());
        List<Commande> commandes = commandeRepository.findByDateAfterOrderByDateDesc(dateLimite);
        if (commandes.isEmpty()) {
            throw new Exception("Aucune commande disponible dans les " + propertiesConfig.getCommandesLast() + " derniers jours");
        }
        return commandes;
    }

    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "fallbackForList")
    @GetMapping("/commandes")
    public List<Commande> getCommandes() throws Exception {
        if (commandeRepository.findAll().isEmpty()) {
            throw new Exception("Aucune commande disponible");
        }
        return commandeRepository.findAll();
    }

    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "fallbackForSingleCommande")
    @GetMapping("/commande/{id}")
    public Commande getCommande(@PathVariable("id") Long id) throws Exception {
        if (commandeRepository.findById(id).isEmpty()) {
            throw new Exception("Commande non trouvée");
        }
        return commandeRepository.findById(id).orElse(null);
    }

    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "fallbackForSingleCommande")
    @PostMapping("/commande")
    public Commande save(@RequestBody Commande commande) throws Exception {
        if (commande.getDate() == null || commande.getMontant() == null || commande.getQuantite() == null) {
            throw new Exception("Commande vide");
        }
        return commandeRepository.save(commande);
    }

    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "fallbackForVoid")
    @DeleteMapping("/commande/{id}")
    public void delete(@PathVariable("id") Long id) {
        commandeRepository.deleteById(id);
    }
}
