package ma.commande.microserviceproduits;

import ma.commande.microserviceproduits.model.Produit;
import ma.commande.microserviceproduits.model.TypeProduit;
import ma.commande.microserviceproduits.repository.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.RandomAccess;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceProduitsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProduitsApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ProduitRepository repository) {
		Random random = new Random();
		return args -> {
			IntStream.rangeClosed(1, 40).forEach(i -> {
				Produit commande = Produit.builder()
						.nom("Produit " + i)
						.type(TypeProduit.getByIndex(random.nextInt(4)))
						.prix(100.0 + i * 10.0)
						.build();
				repository.save(commande);
			});
		};
	}
}
