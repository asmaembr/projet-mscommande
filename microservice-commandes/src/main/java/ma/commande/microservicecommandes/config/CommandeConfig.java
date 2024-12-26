package ma.commande.microservicecommandes.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mes-config-ms")
public class CommandeConfig {
    private Long commandesLast;

    public Long getCommandesLast() {
        return commandesLast;
    }

    public void setCommandesLast(Long commandesLast) {
        this.commandesLast = commandesLast;
    }
}
