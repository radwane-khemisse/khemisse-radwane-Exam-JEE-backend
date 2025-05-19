package sys.radwane.khemisse.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import sys.radwane.khemisse.entities.CreditStatus;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CreditDTO {
    private Long id;
    private Date requestDate;
    private CreditStatus status;
    private Date acceptanceDate;
    private Double amount;
    private Integer repaymentDuration;
    private Double interestRate;
    private Long clientId;
    private String creditType;
} 