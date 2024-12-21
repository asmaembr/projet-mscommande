package ma.commande.microservicecommande;

import ma.commande.microservicecommande.config.CommandeConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(CommandeConfig.class)
public class MicroserviceCommandeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceCommandeApplication.class, args);
    }


}
