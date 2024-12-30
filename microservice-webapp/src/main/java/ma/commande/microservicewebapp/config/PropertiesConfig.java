package ma.commande.microservicewebapp.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "mes-config-ms")
public class PropertiesConfig {

    private String produitApiUrl;
    private String commandeApiUrl;

}
