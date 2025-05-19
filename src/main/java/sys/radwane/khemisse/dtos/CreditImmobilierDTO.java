package sys.radwane.khemisse.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import sys.radwane.khemisse.entities.TypeBien;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CreditImmobilierDTO extends CreditDTO {
    private TypeBien typeBien;
} 