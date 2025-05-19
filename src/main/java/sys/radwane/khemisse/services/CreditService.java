package sys.radwane.khemisse.services;

import sys.radwane.khemisse.dtos.CreditDTO;
import sys.radwane.khemisse.dtos.CreditImmobilierDTO;
import sys.radwane.khemisse.dtos.CreditPersonnelDTO;
import sys.radwane.khemisse.dtos.CreditProfessionnelDTO;
import sys.radwane.khemisse.entities.CreditStatus;

import java.util.List;

public interface CreditService {
    List<CreditDTO> getAllCredits();
    CreditDTO getCreditById(Long id);
    void deleteCredit(Long id);
    
    CreditPersonnelDTO saveCreditPersonnel(CreditPersonnelDTO creditDTO);
    CreditImmobilierDTO saveCreditImmobilier(CreditImmobilierDTO creditDTO);
    CreditProfessionnelDTO saveCreditProfessionnel(CreditProfessionnelDTO creditDTO);
    
    List<CreditDTO> getCreditsByClientId(Long clientId);
    List<CreditDTO> getCreditsByStatus(CreditStatus status);
    CreditDTO updateCreditStatus(Long creditId, CreditStatus newStatus);
} 