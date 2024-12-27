package ma.commande.microservicecommandes.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.commande.microservicecommandes.config.CommandeConfig;
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
    private CommandeConfig commandeConfig;

    public List<Commande> FallbackMessage(Exception t) {
        System.out.println("\u001B[1;31mCircuit Breaker triggered due to: " + t.getMessage() + "\u001B[0m");
        return List.of();
    }

    @GetMapping("/historique")
    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "FallbackMessage")
    public List<Commande> getCommandesDerniersJours() throws Exception {
        LocalDate dateLimite = LocalDate.now().minusDays(commandeConfig.getCommandesLast());
        List<Commande> commandes = commandeRepository.findByDateAfterOrderByDateDesc(dateLimite);
        if (commandes.isEmpty()) {
            throw new Exception("Aucune commande disponible dans les " + commandeConfig.getCommandesLast() + " derniers jours");
        }
        return commandes;
    }

    @GetMapping("/commandes")
    public List<Commande> getCommandes() {
        return commandeRepository.findAll();
    }

    @GetMapping("/commande/{id}")
    public Commande getCommande(@PathVariable("id") Long id) {
        return commandeRepository.findById(id).orElse(null);
    }

    @PostMapping("/commande")
    public Commande save(@RequestBody Commande commande) {
        commandeRepository.save(commande);
        return commande;
    }

    @DeleteMapping("/commande/{id}")
    public void delete(@PathVariable("id") Long id) {
        commandeRepository.deleteById(id);
    }

}
