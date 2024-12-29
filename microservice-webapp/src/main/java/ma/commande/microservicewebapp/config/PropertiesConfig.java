package ma.commande.microservicewebapp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mes-config-ms")
@Data
public class PropertiesConfig {
    private String produitApiUrl;
    private String commandeApiUrl;
}
