package ma.commande.microservicewebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientProxy {
    @Autowired
    private RestTemplate restTemplate;
}
