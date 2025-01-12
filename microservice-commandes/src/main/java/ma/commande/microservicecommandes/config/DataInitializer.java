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
            // Data for earlier dates (30 entries)

            // Electronics orders
            repository.save(Commande.builder()
                    .description("Order for 2 Dell XPS 13 laptops")
                    .quantite(2)
                    .date(LocalDate.of(2024, 12, 20))
                    .montant(3000.00) // 2 * 1500.00
                    .idProduit(1L)
                    .build());
            repository.save(Commande.builder()
                    .description("Order for 5 Sony Noise Cancelling Headphones")
                    .quantite(5)
                    .date(LocalDate.of(2024, 12, 21))
                    .montant(1750.00) // 5 * 350.00
                    .idProduit(2L)
                    .build());
            repository.save(Commande.builder()
                    .description("Order for 3 Samsung Galaxy S21 smartphones")
                    .quantite(3)
                    .date(LocalDate.of(2024, 12, 22))
                    .montant(2997.00) // 3 * 999.00
                    .idProduit(3L)
                    .build());
            repository.save(Commande.builder()
                    .description("Order for 1 Apple MacBook Pro 16-inch")
                    .quantite(1)
                    .date(LocalDate.of(2024, 12, 23))
                    .montant(2400.00) // 1 * 2400.00
                    .idProduit(4L)
                    .build());
            repository.save(Commande.builder()
                    .description("Order for 2 GoPro HERO10 Black cameras")
                    .quantite(2)
                    .date(LocalDate.of(2024, 12, 24))
                    .montant(900.00) // 2 * 450.00
                    .idProduit(5L)
                    .build());

            // Accessories orders
            repository.save(Commande.builder()
                    .description("Order for 3 Apple AirPods Pro")
                    .quantite(3)
                    .date(LocalDate.of(2024, 12, 25))
                    .montant(750.00) // 3 * 250.00
                    .idProduit(6L)
                    .build());
            repository.save(Commande.builder()
                    .description("Order for 1 Anker PowerCore Portable Charger")
                    .quantite(1)
                    .date(LocalDate.of(2024, 12, 26))
                    .montant(40.00) // 1 * 40.00
                    .idProduit(7L)
                    .build());
            repository.save(Commande.builder()
                    .description("Order for 2 Logitech Wireless Mouses")
                    .quantite(2)
                    .date(LocalDate.of(2024, 12, 27))
                    .montant(60.00) // 2 * 30.00
                    .idProduit(8L)
                    .build());
            repository.save(Commande.builder()
                    .description("Order for 3 Samsung Wireless Chargers")
                    .quantite(3)
                    .date(LocalDate.of(2024, 12, 28))
                    .montant(180.00) // 3 * 60.00
                    .idProduit(9L)
                    .build());
            repository.save(Commande.builder()
                    .description("Order for 4 Bose SoundLink Bluetooth Speakers")
                    .quantite(4)
                    .date(LocalDate.of(2024, 12, 29))
                    .montant(796.00) // 4 * 199.00
                    .idProduit(10L)
                    .build());

            // Home Appliances orders
            repository.save(Commande.builder()
                    .description("Order for 1 Samsung Smart Refrigerator")
                    .quantite(1)
                    .date(LocalDate.of(2024, 12, 30))
                    .montant(2200.00) // 1 * 2200.00
                    .idProduit(11L)
                    .build());
            repository.save(Commande.builder()
                    .description("Order for 2 Dyson V11 Cordless Vacuums")
                    .quantite(2)
                    .date(LocalDate.of(2024, 12, 31))
                    .montant(1200.00) // 2 * 600.00
                    .idProduit(12L)
                    .build());
            repository.save(Commande.builder()
                    .description("Order for 3 Instant Pot Pressure Cookers")
                    .quantite(3)
                    .date(LocalDate.of(2025, 1, 1))
                    .montant(360.00) // 3 * 120.00
                    .idProduit(13L)
                    .build());
            repository.save(Commande.builder()
                    .description("Order for 1 Philips Sonicare Electric Toothbrush")
                    .quantite(1)
                    .date(LocalDate.of(2025, 1, 2))
                    .montant(180.00) // 1 * 180.00
                    .idProduit(14L)
                    .build());
            repository.save(Commande.builder()
                    .description("Order for 2 LG Washing Machines")
                    .quantite(2)
                    .date(LocalDate.of(2025, 1, 3))
                    .montant(1700.00) // 2 * 850.00
                    .idProduit(15L)
                    .build());

            // Sports orders
            repository.save(Commande.builder()
                    .description("Order for 2 Nike Air Zoom Pegasus running shoes")
                    .quantite(2)
                    .date(LocalDate.of(2025, 1, 4))
                    .montant(240.00) // 2 * 120.00
                    .idProduit(16L)
                    .build());
            repository.save(Commande.builder()
                    .description("Order for 1 Wilson Tennis Racket")
                    .quantite(1)
                    .date(LocalDate.of(2025, 1, 5))
                    .montant(150.00) // 1 * 150.00
                    .idProduit(17L)
                    .build());
            repository.save(Commande.builder()
                    .description("Order for 2 Adidas Soccer Balls")
                    .quantite(2)
                    .date(LocalDate.of(2025, 1, 6))
                    .montant(50.00) // 2 * 25.00
                    .idProduit(18L)
                    .build());

            // Furniture orders
            repository.save(Commande.builder()
                    .description("Order for 1 Ikea EKTORP Sofa")
                    .quantite(1)
                    .date(LocalDate.of(2025, 1, 7))
                    .montant(400.00) // 1 * 400.00
                    .idProduit(19L)
                    .build());
            repository.save(Commande.builder()
                    .description("Order for 2 Herman Miller Aeron Chairs")
                    .quantite(2)
                    .date(LocalDate.of(2025, 1, 8))
                    .montant(2400.00) // 2 * 1200.00
                    .idProduit(20L)
                    .build());

            // Music orders
            repository.save(Commande.builder()
                    .description("Order for 1 Fender American Professional Stratocaster")
                    .quantite(1)
                    .date(LocalDate.of(2025, 1, 9))
                    .montant(1300.00) // 1 * 1300.00
                    .idProduit(21L)
                    .build());
            repository.save(Commande.builder()
                    .description("Order for 3 Yamaha P-45 Digital Pianos")
                    .quantite(3)
                    .date(LocalDate.of(2025, 1, 10))
                    .montant(1350.00) // 3 * 450.00
                    .idProduit(22L)
                    .build());

            // Data for the last 10 days (realistic history)
            for (int i = 0; i < 10; i++) {
                LocalDate orderDate = LocalDate.now().minusDays(i);
                repository.save(Commande.builder()
                        .description("Order for product " + (i + 1))
                        .quantite(1)
                        .date(orderDate)
                        .montant(100.00 + (i * 50)) // Dynamic price
                        .idProduit((long) (i + 1))
                        .build());
            }
        };
    }
}
