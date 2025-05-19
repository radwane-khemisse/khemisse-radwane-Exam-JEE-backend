package sys.radwane.khemisse.services;

import sys.radwane.khemisse.dtos.RemboursementDTO;
import sys.radwane.khemisse.entities.RemboursementType;

import java.util.Date;
import java.util.List;

public interface RemboursementService {
    List<RemboursementDTO> getAllRemboursements();
    RemboursementDTO getRemboursementById(Long id);
    RemboursementDTO saveRemboursement(RemboursementDTO remboursementDTO);
    RemboursementDTO updateRemboursement(RemboursementDTO remboursementDTO);
    void deleteRemboursement(Long id);
    
    List<RemboursementDTO> getRemboursementsByCreditId(Long creditId);
    List<RemboursementDTO> getRemboursementsByType(RemboursementType type);
    List<RemboursementDTO> getRemboursementsByDateRange(Date startDate, Date endDate);
    Double getTotalRemboursementAmountForCredit(Long creditId);
} 