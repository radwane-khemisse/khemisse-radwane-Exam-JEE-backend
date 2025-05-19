package sys.radwane.khemisse.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sys.radwane.khemisse.entities.RemboursementType;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RemboursementDTO {
    private Long id;
    private Date date;
    private Double amount;
    private RemboursementType type;
    private Long creditId;
} 