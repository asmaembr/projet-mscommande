package ma.commande.microserviceproduits.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.commande.microserviceproduits.model.Produit;
import ma.commande.microserviceproduits.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitController {

    @Autowired
    private ProduitRepository produitRepository;
// Circuit Breaker Fallback methode pour /produits
    public List<Produit> fallbackForList(Exception t) {
        System.out.println("\u001B[1;31mCircuit Breaker triggered due to: " + t.getMessage() + "\u001B[0m");
        return List.of();
    }
// Circuit Breaker Fallback methode pour /produit/{id} et /produit (Post) et (Get)
    public Produit fallbackForSingleProduit(Exception t) {
        System.out.println("\u001B[1;31mCircuit Breaker triggered due to: " + t.getMessage() + "\u001B[0m");
        return null;
    }
// Circuit Breaker Fallback methode pour /produit/{id} (Delete)
    public void fallbackForVoid(Exception t) {
        System.out.println("\u001B[1;31mCircuit Breaker triggered due to: " + t.getMessage() + "\u001B[0m");
    }

    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "fallbackForList")
    @GetMapping("/produits")
    public List<Produit> getProduits() throws Exception {
        if (produitRepository.findAll().isEmpty()) {
            throw new Exception("Aucun produit disponible");
        }
        return produitRepository.findAll();
    }

    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "fallbackForSingleProduit")
    @GetMapping("/produit/{id}")
    public Produit getProduit(@PathVariable("id") Long id) throws Exception {
        if (produitRepository.findById(id).isEmpty()) {
            throw new Exception("Produit non trouvé");
        }
        return produitRepository.findById(id).get();
    }

    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "fallbackForSingleProduit")
    @PostMapping("/produit")
    public Produit save(@RequestBody Produit produit) throws Exception {
        if (produit == null) {
            throw new Exception("Produit vide");
        }
        return produitRepository.save(produit);
    }

    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "fallbackForVoid")
    @DeleteMapping("/produit/{id}")
    public void deleteProduit(@PathVariable("id") Long id) {
        produitRepository.deleteById(id);
    }
}
