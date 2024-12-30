package ma.commande.microservicewebapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
    private Long id;
    private String nom;
    private Double prix;
    private TypeProduit type;
}
