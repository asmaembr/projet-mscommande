package ma.commande.microservicecommandes;

import ma.commande.microservicecommandes.model.Commande;
import ma.commande.microservicecommandes.repository.CommandeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.stream.IntStream;

@EnableDiscoveryClient
@EnableConfigurationProperties
@SpringBootApplication
public class MicroserviceCommandesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceCommandesApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(CommandeRepository repository) {
        return args -> {
            IntStream.rangeClosed(1, 40).forEach(i -> {
                Commande commande = Commande.builder()
                        .description("Commande " + i)
                        .quantite(i * 10)
                        .date(LocalDate.now().minusDays(i))
                        .montant(100.0 + i * 10.0)
                        .build();
                repository.save(commande);
            });
        };
    }

}