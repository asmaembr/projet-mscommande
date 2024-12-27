package ma.commande.microserviceproduits.repository;

import ma.commande.microserviceproduits.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
