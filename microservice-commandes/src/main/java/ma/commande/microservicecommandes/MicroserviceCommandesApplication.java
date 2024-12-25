package ma.commande.microservicecommandes;

import ma.commande.microservicecommandes.model.Commande;
import ma.commande.microservicecommandes.repository.CommandeRepository;
import ma.commande.microservicecommandes.service.CommandeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.stream.IntStream;

@EnableDiscoveryClient
@EnableConfigurationProperties
@SpringBootApplication
public class MicroserviceCommandesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCommandesApplication.class, args);
	}




}
