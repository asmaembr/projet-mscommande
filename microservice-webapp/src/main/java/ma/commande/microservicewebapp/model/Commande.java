package ma.commande.microservicewebapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Commande {
    private Long id;
    private String description;
    private Integer quantite;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private Double montant;
    private Long idProduit;
}
