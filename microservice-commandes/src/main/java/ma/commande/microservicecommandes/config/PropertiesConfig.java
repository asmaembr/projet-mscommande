package ma.commande.microservicecommandes.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mes-config-ms")
@Data
public class PropertiesConfig {

    private Long commandesLast;

}
