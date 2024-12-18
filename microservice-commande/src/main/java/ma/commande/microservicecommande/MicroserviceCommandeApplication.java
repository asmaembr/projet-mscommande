package ma.commande.microservicecommande;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceCommandeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceCommandeApplication.class, args);
    }

}
