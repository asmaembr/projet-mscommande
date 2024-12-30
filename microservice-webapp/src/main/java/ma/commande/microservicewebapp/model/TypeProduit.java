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
    public  static TypeProduit getByName(String name) {
        for (TypeProduit type : TypeProduit.values()) {
            if (type.name().equals(name)) {
                return type;
            }
        }
        return null;
    }
}
