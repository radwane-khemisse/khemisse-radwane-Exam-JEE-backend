package sys.radwane.khemisse.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Remboursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    private Date date;
    
    private Double amount;
    
    @Enumerated(EnumType.STRING)
    private RemboursementType type;
    
    @ManyToOne
    @JoinColumn(name = "credit_id")
    private Credit credit;
} 