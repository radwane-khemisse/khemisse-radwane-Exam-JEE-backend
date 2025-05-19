package sys.radwane.khemisse.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CreditProfessionnelDTO extends CreditDTO {
    private String motif;
    private String raisonSociale;
} 