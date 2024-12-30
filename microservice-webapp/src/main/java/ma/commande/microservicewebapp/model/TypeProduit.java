package ma.commande.microservicewebapp.model;

public enum TypeProduit {
    ALIMENTAIRE,
    ELECTRONIQUE,
    MENAGER,
    HYGIENE,
    AUTRE;

    public static TypeProduit getByIndex(int index) {
        return TypeProduit.values()[index];
    }
}
