package ma.commande.microservicecommandes.service;

import ma.commande.microservicecommandes.model.Commande;
import ma.commande.microservicecommandes.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.stream.IntStream;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository repository;


    public void initData() {
        IntStream.rangeClosed(1, 40).forEach(i -> {
            Commande commande = Commande.builder()
                    .description("Commande " + i)
                    .quantite(i * 10)
                    .date(LocalDate.now().minusDays(i))
                    .montant(100.0 + i * 10.0)
                    .build();
            repository.save(commande);
        });
    }
}

