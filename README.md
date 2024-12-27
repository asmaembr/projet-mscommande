# Microservices with Spring Cloud

This project consists of two microservices , an API gateway , an Eureka Dashbord for monitoring and a Cloud Server to provide the configuration files :

1. **Config Server** - Runs on port `8000`.
2. **Eureka Server**- Runs on port `9000`.
3. **Zuul Server** - Runs on port `9001`.
5. **ProduitMS** - Runs on port `9002`.
4. **CommandeMS** - Runs on port `9003`.

## Port Configuration

| Microservices      | Port  |
|--------------------|-------|
| Config Server      | 8000  |
| Eureka Server      | 9000  |
| Zuul Server      | 9001  |
| Prouit Microservice (microservice-produits)      | 9002 |
| Commande Microservice (microservice-commandes) | 9003  |

---

# Etude de cas (1)

### Controller de l'API microservice-commandes

| Methode | Request List | Function  |
|---------|--------------|-----------|
| Get     | /historique  | retourne les commandes par date|
| Get     | /commandes   | retourne tous les commandes |
| Get     | /commande/{id}| retourne la commande selon le id|
| Post    | /commande | Enregistre ou met à jour les commandes |
| Delete  | /commande/{id}  |supprime la commande selon l'id|

---

# Etude de cas (2)

### Controller de l'API microservice-produits

| Methode | Request List | Function  |
|---------|--------------|-----------|
| Get     | /produits    | retourne tous les produits |
| Get     | /produit/{id}| retourne le produit selon le id|
| Post    | /produit | Enregistre ou met à jour le produit |
| Delete  | /produit/{id}  |supprime le produit selon l'id|

---

### Mise à jour du controller de l'API microservice-commandes

| Methode | Request List | Function  |
|---------|--------------|-----------|
| Get     | /historique  | retourne les commandes par date|
| Get     | /getProduits  | retourne les produits de cette commande|
| Get     | /commandes   | retourne tous les commandes |
| Get     | /commande/{id}| retourne la commande selon le id|
| Post    | /commande | Enregistre ou met à jour les commandes |
| Delete  | /commande/{id}  |supprime la commande selon l'id|

---

### Developed By

- **Asmae Moubarriz**
- **Achraf Akrache**
