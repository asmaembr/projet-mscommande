package ma.commande.microservicecommandes.config;

import ma.commande.microservicecommandes.model.Commande;
import ma.commande.microservicecommandes.repository.CommandeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(CommandeRepository repository) {
        return args -> {
            // Données pour les dates précédentes (30 entrées)

            // Commandes électroniques
            repository.save(Commande.builder()
                    .description("Commande de 2 ordinateurs portables Dell XPS 13")
                    .quantite(2)
                    .date(LocalDate.of(2024, 12, 20))
                    .montant(3000.00) // 2 * 1500.00
                    .idProduit(1L)
                    .build());
            repository.save(Commande.builder()
                    .description("Commande de 5 casques Sony à réduction de bruit")
                    .quantite(5)
                    .date(LocalDate.of(2024, 12, 21))
                    .montant(1750.00) // 5 * 350.00
                    .idProduit(2L)
                    .build());
            repository.save(Commande.builder()
                    .description("Commande de 3 smartphones Samsung Galaxy S21")
                    .quantite(3)
                    .date(LocalDate.of(2024, 12, 22))
                    .montant(2997.00) // 3 * 999.00
                    .idProduit(3L)
                    .build());
            repository.save(Commande.builder()
                    .description("Commande d'un MacBook Pro 16 pouces d'Apple")
                    .quantite(1)
                    .date(LocalDate.of(2024, 12, 23))
                    .montant(2400.00) // 1 * 2400.00
                    .idProduit(4L)
                    .build());
            repository.save(Commande.builder()
                    .description("Commande de 2 caméras GoPro HERO10 Black")
                    .quantite(2)
                    .date(LocalDate.of(2024, 12, 24))
                    .montant(900.00) // 2 * 450.00
                    .idProduit(5L)
                    .build());

            // Commandes d'accessoires
            repository.save(Commande.builder()
                    .description("Commande de 3 Apple AirPods Pro")
                    .quantite(3)
                    .date(LocalDate.of(2024, 12, 25))
                    .montant(750.00) // 3 * 250.00
                    .idProduit(6L)
                    .build());
            repository.save(Commande.builder()
                    .description("Commande d'un chargeur portable Anker PowerCore")
                    .quantite(1)
                    .date(LocalDate.of(2024, 12, 26))
                    .montant(40.00) // 1 * 40.00
                    .idProduit(7L)
                    .build());
            repository.save(Commande.builder()
                    .description("Commande de 2 souris sans fil Logitech")
                    .quantite(2)
                    .date(LocalDate.of(2024, 12, 27))
                    .montant(60.00) // 2 * 30.00
                    .idProduit(8L)
                    .build());
            repository.save(Commande.builder()
                    .description("Commande de 3 chargeurs sans fil Samsung")
                    .quantite(3)
                    .date(LocalDate.of(2024, 12, 28))
                    .montant(180.00) // 3 * 60.00
                    .idProduit(9L)
                    .build());
            repository.save(Commande.builder()
                    .description("Commande de 4 enceintes Bluetooth Bose SoundLink")
                    .quantite(4)
                    .date(LocalDate.of(2024, 12, 29))
                    .montant(796.00) // 4 * 199.00
                    .idProduit(10L)
                    .build());

            // Commandes d'électroménagers
            repository.save(Commande.builder()
                    .description("Commande d'un réfrigérateur intelligent Samsung")
                    .quantite(1)
                    .date(LocalDate.of(2024, 12, 30))
                    .montant(2200.00) // 1 * 2200.00
                    .idProduit(11L)
                    .build());
            repository.save(Commande.builder()
                    .description("Commande de 2 aspirateurs sans fil Dyson V11")
                    .quantite(2)
                    .date(LocalDate.of(2024, 12, 31))
                    .montant(1200.00) // 2 * 600.00
                    .idProduit(12L)
                    .build());
            repository.save(Commande.builder()
                    .description("Commande de 3 cocottes-minute Instant Pot")
                    .quantite(3)
                    .date(LocalDate.of(2025, 1, 1))
                    .montant(360.00) // 3 * 120.00
                    .idProduit(13L)
                    .build());
            repository.save(Commande.builder()
                    .description("Commande d'une brosse à dents électrique Philips Sonicare")
                    .quantite(1)
                    .date(LocalDate.of(2025, 1, 2))
                    .montant(180.00) // 1 * 180.00
                    .idProduit(14L)
                    .build());
            repository.save(Commande.builder()
                    .description("Commande de 2 lave-linge LG")
                    .quantite(2)
                    .date(LocalDate.of(2025, 1, 3))
                    .montant(1700.00) // 2 * 850.00
                    .idProduit(15L)
                    .build());

            // Commandes de sport
            repository.save(Commande.builder()
                    .description("Commande de 2 chaussures de course Nike Air Zoom Pegasus")
                    .quantite(2)
                    .date(LocalDate.of(2025, 1, 4))
                    .montant(240.00) // 2 * 120.00
                    .idProduit(16L)
                    .build());
            repository.save(Commande.builder()
                    .description("Commande d'une raquette de tennis Wilson")
                    .quantite(1)
                    .date(LocalDate.of(2025, 1, 5))
                    .montant(150.00) // 1 * 150.00
                    .idProduit(17L)
                    .build());
            repository.save(Commande.builder()
                    .description("Commande de 2 ballons de football Adidas")
                    .quantite(2)
                    .date(LocalDate.of(2025, 1, 6))
                    .montant(50.00) // 2 * 25.00
                    .idProduit(18L)
                    .build());

            // Commandes de meubles
            repository.save(Commande.builder()
                    .description("Commande d'un canapé Ikea EKTORP")
                    .quantite(1)
                    .date(LocalDate.of(2025, 1, 7))
                    .montant(400.00) // 1 * 400.00
                    .idProduit(19L)
                    .build());
            repository.save(Commande.builder()
                    .description("Commande de 2 chaises Herman Miller Aeron")
                    .quantite(2)
                    .date(LocalDate.of(2025, 1, 8))
                    .montant(2400.00) // 2 * 1200.00
                    .idProduit(20L)
                    .build());

            // Commandes de musique
            repository.save(Commande.builder()
                    .description("Commande d'une Fender American Professional Stratocaster")
                    .quantite(1)
                    .date(LocalDate.of(2025, 1, 9))
                    .montant(1300.00) // 1 * 1300.00
                    .idProduit(21L)
                    .build());
            repository.save(Commande.builder()
                    .description("Commande de 3 pianos numériques Yamaha P-45")
                    .quantite(3)
                    .date(LocalDate.of(2025, 1, 10))
                    .montant(1350.00) // 3 * 450.00
                    .idProduit(22L)
                    .build());
        };
    }
}
