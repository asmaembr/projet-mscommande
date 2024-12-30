package ma.commande.microservicewebapp.service;

import ma.commande.microservicewebapp.config.PropertiesConfig;
import ma.commande.microservicewebapp.model.Commande;
import ma.commande.microservicewebapp.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Configuration
@Service
public class ClientProxy {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PropertiesConfig propertiesConfig;

    public List<Produit> getAllProduits() {
        String url = propertiesConfig.getProduitApiUrl() + "/produits";
        Produit[] produits = restTemplate.getForObject(url, Produit[].class);
        return Arrays.asList(produits);
    }

    public Produit getProduitById(Long id) {
        String url = propertiesConfig.getProduitApiUrl() + "/produit/" + id;
        return restTemplate.getForObject(url, Produit.class);
    }

    public Produit saveProduit(Produit produit) {
        String url = propertiesConfig.getProduitApiUrl() + "/produit";
        return restTemplate.postForObject(url, produit, Produit.class);
    }

    public void deleteProduit(Long id) {
        String url = propertiesConfig.getProduitApiUrl() + "/produit/" + id;
        restTemplate.delete(url);
    }

    public List<Commande> getAllCommandes() {
        String url = propertiesConfig.getCommandeApiUrl() + "/commandes";
        Commande[] commandes = restTemplate.getForObject(url, Commande[].class);
        return Arrays.asList(commandes);
    }

    public  Commande getCommandeById(Long id) {
        String url = propertiesConfig.getCommandeApiUrl() + "/commande/" + id;
        return restTemplate.getForObject(url, Commande.class);
    }

    public Commande saveCommande(Commande commande) {
        String url = propertiesConfig.getCommandeApiUrl() + "/commande";
        return restTemplate.postForObject(url, commande, Commande.class);
    }

    public void deleteCommande(Long id) {

        String url = propertiesConfig.getCommandeApiUrl() + "/commande/" + id;
        restTemplate.delete(url);
    }

    public List<Commande> getHistoriqueCommandes() {
        String url = propertiesConfig.getCommandeApiUrl() + "/historique";
        Commande[] commandes = restTemplate.getForObject(url, Commande[].class);
        return Arrays.asList(commandes);
    }

}
