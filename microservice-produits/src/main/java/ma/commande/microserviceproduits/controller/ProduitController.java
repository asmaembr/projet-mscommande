package ma.commande.microserviceproduits.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.commande.microserviceproduits.model.Produit;
import ma.commande.microserviceproduits.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "FallbackMessage")
public class ProduitController {

    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> FallbackMessage(Exception t) {
        System.out.println("\u001B[1;31mCircuit Breaker triggered due to: " + t.getMessage() + "\u001B[0m");
        return List.of();
    }

    @GetMapping("/produits")
    public List<Produit> getProduits() throws Exception {
        if( produitRepository.findAll().isEmpty() ) {
            throw new Exception("Aucun produit disponible");
        }
        return produitRepository.findAll();
    }

    @GetMapping("/produit/{id}")
    public Produit getProduit(@PathVariable("id") Long id) throws Exception{
        if( produitRepository.findById(id).isEmpty()){
            throw new Exception("Produit non trouvé");
        }
        return produitRepository.findById(id).get();
    }

    @PostMapping("/produit")
    public Produit save(@RequestBody Produit produit) throws Exception {
        if(produit==null) {
            throw new Exception("Produit vide");
        }
        return produitRepository.save(produit);
    }

    @DeleteMapping("/produit/{id}")
    public void deleteProduit(@PathVariable("id") Long id) {
        produitRepository.deleteById(id);
    }
}
