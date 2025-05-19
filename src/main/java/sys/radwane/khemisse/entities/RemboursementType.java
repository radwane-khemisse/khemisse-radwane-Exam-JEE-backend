package sys.radwane.khemisse.entities;

public enum RemboursementType {
    MENSUALITE("Mensualité"),
    REMBOURSEMENT_ANTICIPE("Remboursement anticipé");
    
    private final String label;
    
    RemboursementType(String label) {
        this.label = label;
    }
    
    public String getLabel() {
        return label;
    }
} 