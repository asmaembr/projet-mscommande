package ma.commande.microservicecommande.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.commande.microservicecommande.model.Commande;

@Repository

public interface CommandeRepository extends JpaRepository<Commande, Long> {

     List<Commande> findByDateAfter(LocalDate date);
}
