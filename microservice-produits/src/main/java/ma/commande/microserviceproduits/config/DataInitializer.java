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
            // Électroniques (5 produits)
            repository.save(Produit.builder()
                    .nom("Dell XPS 13")
                    .prix(1500.00)
                    .type(TypeProduit.ELECTRONIQUE)  // index 0
                    .build());
            repository.save(Produit.builder()
                    .nom("Casque Sony à réduction de bruit")
                    .prix(350.00)
                    .type(TypeProduit.ELECTRONIQUE)  // index 0
                    .build());
            repository.save(Produit.builder()
                    .nom("Samsung Galaxy S21")
                    .prix(999.00)
                    .type(TypeProduit.ELECTRONIQUE)  // index 0
                    .build());
            repository.save(Produit.builder()
                    .nom("Apple MacBook Pro 16 pouces")
                    .prix(2400.00)
                    .type(TypeProduit.ELECTRONIQUE)  // index 0
                    .build());
            repository.save(Produit.builder()
                    .nom("GoPro HERO10 Black")
                    .prix(450.00)
                    .type(TypeProduit.ELECTRONIQUE)  // index 0
                    .build());

            // Accessoires (5 produits)
            repository.save(Produit.builder()
                    .nom("Apple AirPods Pro")
                    .prix(250.00)
                    .type(TypeProduit.ACCESSOIRE)  // index 1
                    .build());
            repository.save(Produit.builder()
                    .nom("Chargeur portable Anker PowerCore")
                    .prix(40.00)
                    .type(TypeProduit.ACCESSOIRE)  // index 1
                    .build());
            repository.save(Produit.builder()
                    .nom("Souris sans fil Logitech")
                    .prix(30.00)
                    .type(TypeProduit.ACCESSOIRE)  // index 1
                    .build());
            repository.save(Produit.builder()
                    .nom("Chargeur sans fil Samsung")
                    .prix(60.00)
                    .type(TypeProduit.ACCESSOIRE)  // index 1
                    .build());
            repository.save(Produit.builder()
                    .nom("Enceinte Bluetooth Bose SoundLink")
                    .prix(199.00)
                    .type(TypeProduit.ACCESSOIRE)  // index 1
                    .build());

            // Électroménager (5 produits)
            repository.save(Produit.builder()
                    .nom("Réfrigérateur intelligent Samsung")
                    .prix(2200.00)
                    .type(TypeProduit.ELECTROMENAGER) // index 2
                    .build());
            repository.save(Produit.builder()
                    .nom("Aspirateur sans fil Dyson V11")
                    .prix(600.00)
                    .type(TypeProduit.ELECTROMENAGER) // index 2
                    .build());
            repository.save(Produit.builder()
                    .nom("Cocotte-minute Instant Pot")
                    .prix(120.00)
                    .type(TypeProduit.ELECTROMENAGER) // index 2
                    .build());
            repository.save(Produit.builder()
                    .nom("Brosse à dents électrique Philips Sonicare")
                    .prix(180.00)
                    .type(TypeProduit.ELECTROMENAGER) // index 2
                    .build());
            repository.save(Produit.builder()
                    .nom("Lave-linge LG")
                    .prix(850.00)
                    .type(TypeProduit.ELECTROMENAGER) // index 2
                    .build());

            // Sports (3 produits)
            repository.save(Produit.builder()
                    .nom("Nike Air Zoom Pegasus")
                    .prix(120.00)
                    .type(TypeProduit.SPORT) // index 3
                    .build());
            repository.save(Produit.builder()
                    .nom("Raquette de tennis Wilson")
                    .prix(150.00)
                    .type(TypeProduit.SPORT) // index 3
                    .build());
            repository.save(Produit.builder()
                    .nom("Ballon de football Adidas")
                    .prix(25.00)
                    .type(TypeProduit.SPORT) // index 3
                    .build());

            // Meubles (2 produits)
            repository.save(Produit.builder()
                    .nom("Canapé Ikea EKTORP")
                    .prix(400.00)
                    .type(TypeProduit.MEUBLE) // index 4
                    .build());
            repository.save(Produit.builder()
                    .nom("Chaise Herman Miller Aeron")
                    .prix(1200.00)
                    .type(TypeProduit.MEUBLE) // index 4
                    .build());

            // Musique (3 produits)
            repository.save(Produit.builder()
                    .nom("Fender American Professional Stratocaster")
                    .prix(1300.00)
                    .type(TypeProduit.MUSIQUE) // index 5
                    .build());
            repository.save(Produit.builder()
                    .nom("Piano numérique Yamaha P-45")
                    .prix(450.00)
                    .type(TypeProduit.MUSIQUE) // index 5
                    .build());
            repository.save(Produit.builder()
                    .nom("Casque Bose QuietComfort 35 II")
                    .prix(300.00)
                    .type(TypeProduit.MUSIQUE) // index 5
                    .build());
        };
    }
}
