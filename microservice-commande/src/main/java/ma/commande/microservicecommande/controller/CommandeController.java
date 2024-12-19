package ma.commande.microservicecommande.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ma.commande.microservicecommande.config.CommandeConfig;
import ma.commande.microservicecommande.model.Commande;
import ma.commande.microservicecommande.repository.CommandeRepository;

@Controller

public class CommandeController {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private CommandeConfig commandeConfig;

    public List<Commande> getCommandesRecuesDerniersJours() {
        LocalDate dateLimite = LocalDate.now().minusDays(commandeConfig.getCommandesLast());
        return commandeRepository.findByDateAfter(dateLimite);
    }
}
