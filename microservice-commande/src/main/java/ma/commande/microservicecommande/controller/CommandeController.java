package ma.commande.microservicecommande.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.commande.microservicecommande.config.CommandeConfig;
import ma.commande.microservicecommande.model.Commande;
import ma.commande.microservicecommande.repository.CommandeRepository;
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

    public List<Commande> FallbackMessage(Throwable t) {
        System.out.println("Fallback triggered due to: " + t.getMessage());
        return List.of();
    }
    /* private String myHistrixbuildFallbackMessage() {
         return "Message from myHistrixbuildFallbackMessage() : Hystrix Fallback message ( after timeout : 1 second )";
     }
    @HystrixCommand(fallbackMethod = "myHistrixbuildFallbackMessage",
             commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")},
             threadPoolKey = "messageThreadPool") */

    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "FallbackMessage")
    @GetMapping("/commandesparjours")
    public List<Commande> getCommandesDerniersJours() throws Exception {
        LocalDate dateLimite = LocalDate.now().minusDays(commandeConfig.getCommandesLast());
        List<Commande> commandes = commandeRepository.findByDateAfter(dateLimite);
        if (commandes.isEmpty()) {
            throw new Exception("Date limite est null");
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
