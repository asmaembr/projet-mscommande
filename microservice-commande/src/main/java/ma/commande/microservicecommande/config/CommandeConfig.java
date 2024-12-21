package ma.commande.microservicecommande.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mes-config-ms")
public class CommandeConfig {

    private int commandesLast;  // Make sure this is not static

    public int getCommandesLast() {
        return commandesLast;
    }

    public void setCommandesLast(int commandesLast) {
        this.commandesLast = commandesLast;
    }
}
