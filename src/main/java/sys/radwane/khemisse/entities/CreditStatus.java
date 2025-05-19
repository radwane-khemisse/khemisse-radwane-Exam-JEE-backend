package sys.radwane.khemisse.entities;

public enum CreditStatus {
    EN_COURS("En cours"),
    ACCEPTE("Accepté"),
    REJETE("rejeté");
    
    private final String label;
    
    CreditStatus(String label) {
        this.label = label;
    }
    
    public String getLabel() {
        return label;
    }
} 