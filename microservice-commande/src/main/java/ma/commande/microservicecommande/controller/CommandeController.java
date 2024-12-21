package ma.commande.microservicecommande.controller;

import java.time.LocalDate;
import java.util.List;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;


import ma.commande.microservicecommande.config.CommandeConfig;
import ma.commande.microservicecommande.model.Commande;
import ma.commande.microservicecommande.repository.CommandeRepository;

//@CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "FallbackMessage")
@EnableHystrixDashboard
@Configuration
@EnableCircuitBreaker
@RestController
public class CommandeController {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private CommandeConfig commandeConfig;

  /*  public String FallbackMessage(Throwable t) {
        return "Commande Service is down, please try again later!";
    }
    */
  @HystrixCommand(fallbackMethod = "myHistrixbuildFallbackMessage",
          commandProperties ={@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")},
          threadPoolKey = "messageThreadPool")
    @GetMapping("/commandesparjours")
    public List<Commande> getCommandesDerniersJours() throws InterruptedException {
        LocalDate dateLimite = LocalDate.now().minusDays(commandeConfig.getCommandesLast());
        return commandeRepository.findByDateAfter(dateLimite);
    }
    private String myHistrixbuildFallbackMessage() {
        return "Message from myHistrixbuildFallbackMessage() : Hystrix Fallback message ( after timeout : 1 second )";
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
