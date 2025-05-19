package sys.radwane.khemisse.mappers;

import org.springframework.stereotype.Service;
import sys.radwane.khemisse.dtos.RemboursementDTO;
import sys.radwane.khemisse.entities.Credit;
import sys.radwane.khemisse.entities.Remboursement;

@Service
public class RemboursementMapper {

    public RemboursementDTO fromRemboursement(Remboursement remboursement) {
        if (remboursement == null) return null;
        
        return RemboursementDTO.builder()
                .id(remboursement.getId())
                .date(remboursement.getDate())
                .amount(remboursement.getAmount())
                .type(remboursement.getType())
                .creditId(remboursement.getCredit() != null ? remboursement.getCredit().getId() : null)
                .build();
    }

    public Remboursement fromRemboursementDTO(RemboursementDTO dto, Credit credit) {
        if (dto == null) return null;
        
        Remboursement remboursement = new Remboursement();
        remboursement.setId(dto.getId());
        remboursement.setDate(dto.getDate());
        remboursement.setAmount(dto.getAmount());
        remboursement.setType(dto.getType());
        remboursement.setCredit(credit);
        
        return remboursement;
    }
} 