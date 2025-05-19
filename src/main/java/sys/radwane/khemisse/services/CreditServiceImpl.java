package sys.radwane.khemisse.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sys.radwane.khemisse.dtos.*;
import sys.radwane.khemisse.entities.*;
import sys.radwane.khemisse.mappers.CreditMapper;
import sys.radwane.khemisse.repositories.ClientRepository;
import sys.radwane.khemisse.repositories.CreditRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CreditServiceImpl implements CreditService {
    private CreditRepository creditRepository;
    private ClientRepository clientRepository;
    private CreditMapper creditMapper;

    @Override
    public List<CreditDTO> getAllCredits() {
        List<Credit> credits = creditRepository.findAll();
        return credits.stream()
                .map(creditMapper::fromCredit)
                .collect(Collectors.toList());
    }

    @Override
    public CreditDTO getCreditById(Long id) {
        Credit credit = creditRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credit not found with id: " + id));
        return creditMapper.fromCredit(credit);
    }

    @Override
    public void deleteCredit(Long id) {
        creditRepository.deleteById(id);
    }

    @Override
    public CreditPersonnelDTO saveCreditPersonnel(CreditPersonnelDTO creditDTO) {
        Client client = getClientForCredit(creditDTO.getClientId());
        CreditPersonnel credit = (CreditPersonnel) creditMapper.fromCreditDTO(creditDTO, client);
        
        if (credit.getStatus() == CreditStatus.ACCEPTE && credit.getAcceptanceDate() == null) {
            credit.setAcceptanceDate(new Date());
        }
        
        CreditPersonnel savedCredit = (CreditPersonnel) creditRepository.save(credit);
        return creditMapper.fromCreditPersonnel(savedCredit);
    }

    @Override
    public CreditImmobilierDTO saveCreditImmobilier(CreditImmobilierDTO creditDTO) {
        Client client = getClientForCredit(creditDTO.getClientId());
        CreditImmobilier credit = (CreditImmobilier) creditMapper.fromCreditDTO(creditDTO, client);
        
        if (credit.getStatus() == CreditStatus.ACCEPTE && credit.getAcceptanceDate() == null) {
            credit.setAcceptanceDate(new Date());
        }
        
        CreditImmobilier savedCredit = (CreditImmobilier) creditRepository.save(credit);
        return creditMapper.fromCreditImmobilier(savedCredit);
    }

    @Override
    public CreditProfessionnelDTO saveCreditProfessionnel(CreditProfessionnelDTO creditDTO) {
        Client client = getClientForCredit(creditDTO.getClientId());
        CreditProfessionnel credit = (CreditProfessionnel) creditMapper.fromCreditDTO(creditDTO, client);
        
        if (credit.getStatus() == CreditStatus.ACCEPTE && credit.getAcceptanceDate() == null) {
            credit.setAcceptanceDate(new Date());
        }
        
        CreditProfessionnel savedCredit = (CreditProfessionnel) creditRepository.save(credit);
        return creditMapper.fromCreditProfessionnel(savedCredit);
    }

    @Override
    public List<CreditDTO> getCreditsByClientId(Long clientId) {
        List<Credit> credits = creditRepository.findByClientId(clientId);
        return credits.stream()
                .map(creditMapper::fromCredit)
                .collect(Collectors.toList());
    }

    @Override
    public List<CreditDTO> getCreditsByStatus(CreditStatus status) {
        List<Credit> credits = creditRepository.findByStatus(status);
        return credits.stream()
                .map(creditMapper::fromCredit)
                .collect(Collectors.toList());
    }

    @Override
    public CreditDTO updateCreditStatus(Long creditId, CreditStatus newStatus) {
        Credit credit = creditRepository.findById(creditId)
                .orElseThrow(() -> new RuntimeException("Credit not found with id: " + creditId));
        
        credit.setStatus(newStatus);
        
        // If status is changed to ACCEPTE, set acceptance date
        if (newStatus == CreditStatus.ACCEPTE && credit.getAcceptanceDate() == null) {
            credit.setAcceptanceDate(new Date());
        }
        
        Credit updatedCredit = creditRepository.save(credit);
        return creditMapper.fromCredit(updatedCredit);
    }
    
    // Helper method to get the client for a credit
    private Client getClientForCredit(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + clientId));
    }
} 