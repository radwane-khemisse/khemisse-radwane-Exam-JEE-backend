package sys.radwane.khemisse.entities;

public enum TypeBien {
    APPARTEMENT("Appartement"),
    MAISON("Maison"),
    LOCAL_COMMERCIAL("Local Commercial");
    
    private final String label;
    
    TypeBien(String label) {
        this.label = label;
    }
    
    public String getLabel() {
        return label;
    }
} 