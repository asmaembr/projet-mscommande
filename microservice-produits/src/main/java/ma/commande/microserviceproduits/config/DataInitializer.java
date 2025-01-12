package ma.commande.microserviceproduits.config;

import ma.commande.microserviceproduits.model.Produit;
import ma.commande.microserviceproduits.model.TypeProduit;
import ma.commande.microserviceproduits.repository.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(ProduitRepository repository) {
        return args -> {
            // Electronics (5 products)
            repository.save(Produit.builder()
                    .nom("Dell XPS 13")
                    .prix(1500.00)
                    .type(TypeProduit.ELECTRONICS)  // index 0
                    .build());
            repository.save(Produit.builder()
                    .nom("Sony Noise Cancelling Headphones")
                    .prix(350.00)
                    .type(TypeProduit.ELECTRONICS)  // index 0
                    .build());
            repository.save(Produit.builder()
                    .nom("Samsung Galaxy S21")
                    .prix(999.00)
                    .type(TypeProduit.ELECTRONICS)  // index 0
                    .build());
            repository.save(Produit.builder()
                    .nom("Apple MacBook Pro 16-inch")
                    .prix(2400.00)
                    .type(TypeProduit.ELECTRONICS)  // index 0
                    .build());
            repository.save(Produit.builder()
                    .nom("GoPro HERO10 Black")
                    .prix(450.00)
                    .type(TypeProduit.ELECTRONICS)  // index 0
                    .build());

            // Accessories (5 products)
            repository.save(Produit.builder()
                    .nom("Apple AirPods Pro")
                    .prix(250.00)
                    .type(TypeProduit.ACCESSORIES)  // index 1
                    .build());
            repository.save(Produit.builder()
                    .nom("Anker PowerCore Portable Charger")
                    .prix(40.00)
                    .type(TypeProduit.ACCESSORIES)  // index 1
                    .build());
            repository.save(Produit.builder()
                    .nom("Logitech Wireless Mouse")
                    .prix(30.00)
                    .type(TypeProduit.ACCESSORIES)  // index 1
                    .build());
            repository.save(Produit.builder()
                    .nom("Samsung Wireless Charger")
                    .prix(60.00)
                    .type(TypeProduit.ACCESSORIES)  // index 1
                    .build());
            repository.save(Produit.builder()
                    .nom("Bose SoundLink Bluetooth Speaker")
                    .prix(199.00)
                    .type(TypeProduit.ACCESSORIES)  // index 1
                    .build());

            // Home Appliances (5 products)
            repository.save(Produit.builder()
                    .nom("Samsung Smart Refrigerator")
                    .prix(2200.00)
                    .type(TypeProduit.HOME_APPLIANCE) // index 2
                    .build());
            repository.save(Produit.builder()
                    .nom("Dyson V11 Cordless Vacuum")
                    .prix(600.00)
                    .type(TypeProduit.HOME_APPLIANCE) // index 2
                    .build());
            repository.save(Produit.builder()
                    .nom("Instant Pot Pressure Cooker")
                    .prix(120.00)
                    .type(TypeProduit.HOME_APPLIANCE) // index 2
                    .build());
            repository.save(Produit.builder()
                    .nom("Philips Sonicare Electric Toothbrush")
                    .prix(180.00)
                    .type(TypeProduit.HOME_APPLIANCE) // index 2
                    .build());
            repository.save(Produit.builder()
                    .nom("LG Washing Machine")
                    .prix(850.00)
                    .type(TypeProduit.HOME_APPLIANCE) // index 2
                    .build());

            // Sports (3 products)
            repository.save(Produit.builder()
                    .nom("Nike Air Zoom Pegasus")
                    .prix(120.00)
                    .type(TypeProduit.SPORTS) // index 3
                    .build());
            repository.save(Produit.builder()
                    .nom("Wilson Tennis Racket")
                    .prix(150.00)
                    .type(TypeProduit.SPORTS) // index 3
                    .build());
            repository.save(Produit.builder()
                    .nom("Adidas Soccer Ball")
                    .prix(25.00)
                    .type(TypeProduit.SPORTS) // index 3
                    .build());

            // Furniture (2 products)
            repository.save(Produit.builder()
                    .nom("Ikea EKTORP Sofa")
                    .prix(400.00)
                    .type(TypeProduit.FURNITURE) // index 4
                    .build());
            repository.save(Produit.builder()
                    .nom("Herman Miller Aeron Chair")
                    .prix(1200.00)
                    .type(TypeProduit.FURNITURE) // index 4
                    .build());

            // Music (3 products)
            repository.save(Produit.builder()
                    .nom("Fender American Professional Stratocaster")
                    .prix(1300.00)
                    .type(TypeProduit.MUSIC) // index 5
                    .build());
            repository.save(Produit.builder()
                    .nom("Yamaha P-45 Digital Piano")
                    .prix(450.00)
                    .type(TypeProduit.MUSIC) // index 5
                    .build());
            repository.save(Produit.builder()
                    .nom("Bose QuietComfort 35 II Headphones")
                    .prix(300.00)
                    .type(TypeProduit.MUSIC) // index 5
                    .build());
        };
    }
}
