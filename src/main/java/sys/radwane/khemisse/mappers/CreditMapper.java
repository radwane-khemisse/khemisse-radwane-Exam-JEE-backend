package sys.radwane.khemisse.mappers;

import org.springframework.stereotype.Service;
import sys.radwane.khemisse.dtos.*;
import sys.radwane.khemisse.entities.*;

@Service
public class CreditMapper {

    public CreditDTO fromCredit(Credit credit) {
        if (credit == null) return null;
        
        CreditDTO.CreditDTOBuilder<?, ?> builder = CreditDTO.builder()
                .id(credit.getId())
                .requestDate(credit.getRequestDate())
                .status(credit.getStatus())
                .acceptanceDate(credit.getAcceptanceDate())
                .amount(credit.getAmount())
                .repaymentDuration(credit.getRepaymentDuration())
                .interestRate(credit.getInterestRate())
                .clientId(credit.getClient() != null ? credit.getClient().getId() : null);
                
        if (credit instanceof CreditPersonnel) {
            return fromCreditPersonnel((CreditPersonnel) credit);
        } else if (credit instanceof CreditImmobilier) {
            return fromCreditImmobilier((CreditImmobilier) credit);
        } else if (credit instanceof CreditProfessionnel) {
            return fromCreditProfessionnel((CreditProfessionnel) credit);
        }
        
        return builder.creditType("CREDIT").build();
    }
    
    public CreditPersonnelDTO fromCreditPersonnel(CreditPersonnel credit) {
        if (credit == null) return null;
        
        return CreditPersonnelDTO.builder()
                .id(credit.getId())
                .requestDate(credit.getRequestDate())
                .status(credit.getStatus())
                .acceptanceDate(credit.getAcceptanceDate())
                .amount(credit.getAmount())
                .repaymentDuration(credit.getRepaymentDuration())
                .interestRate(credit.getInterestRate())
                .clientId(credit.getClient() != null ? credit.getClient().getId() : null)
                .creditType("PERSONNEL")
                .motif(credit.getMotif())
                .build();
    }
    
    public CreditImmobilierDTO fromCreditImmobilier(CreditImmobilier credit) {
        if (credit == null) return null;
        
        return CreditImmobilierDTO.builder()
                .id(credit.getId())
                .requestDate(credit.getRequestDate())
                .status(credit.getStatus())
                .acceptanceDate(credit.getAcceptanceDate())
                .amount(credit.getAmount())
                .repaymentDuration(credit.getRepaymentDuration())
                .interestRate(credit.getInterestRate())
                .clientId(credit.getClient() != null ? credit.getClient().getId() : null)
                .creditType("IMMOBILIER")
                .typeBien(credit.getTypeBien())
                .build();
    }
    
    public CreditProfessionnelDTO fromCreditProfessionnel(CreditProfessionnel credit) {
        if (credit == null) return null;
        
        return CreditProfessionnelDTO.builder()
                .id(credit.getId())
                .requestDate(credit.getRequestDate())
                .status(credit.getStatus())
                .acceptanceDate(credit.getAcceptanceDate())
                .amount(credit.getAmount())
                .repaymentDuration(credit.getRepaymentDuration())
                .interestRate(credit.getInterestRate())
                .clientId(credit.getClient() != null ? credit.getClient().getId() : null)
                .creditType("PROFESSIONNEL")
                .motif(credit.getMotif())
                .raisonSociale(credit.getRaisonSociale())
                .build();
    }
    
    public Credit fromCreditDTO(CreditDTO dto, Client client) {
        if (dto == null) return null;
        
        if (dto instanceof CreditPersonnelDTO) {
            return fromCreditPersonnelDTO((CreditPersonnelDTO) dto, client);
        } else if (dto instanceof CreditImmobilierDTO) {
            return fromCreditImmobilierDTO((CreditImmobilierDTO) dto, client);
        } else if (dto instanceof CreditProfessionnelDTO) {
            return fromCreditProfessionnelDTO((CreditProfessionnelDTO) dto, client);
        }
        
        Credit credit = new Credit();
        mapBaseCreditFields(dto, credit);
        credit.setClient(client);
        return credit;
    }
    
    private CreditPersonnel fromCreditPersonnelDTO(CreditPersonnelDTO dto, Client client) {
        CreditPersonnel credit = new CreditPersonnel();
        mapBaseCreditFields(dto, credit);
        credit.setClient(client);
        credit.setMotif(dto.getMotif());
        return credit;
    }
    
    private CreditImmobilier fromCreditImmobilierDTO(CreditImmobilierDTO dto, Client client) {
        CreditImmobilier credit = new CreditImmobilier();
        mapBaseCreditFields(dto, credit);
        credit.setClient(client);
        credit.setTypeBien(dto.getTypeBien());
        return credit;
    }
    
    private CreditProfessionnel fromCreditProfessionnelDTO(CreditProfessionnelDTO dto, Client client) {
        CreditProfessionnel credit = new CreditProfessionnel();
        mapBaseCreditFields(dto, credit);
        credit.setClient(client);
        credit.setMotif(dto.getMotif());
        credit.setRaisonSociale(dto.getRaisonSociale());
        return credit;
    }
    
    private void mapBaseCreditFields(CreditDTO dto, Credit credit) {
        credit.setId(dto.getId());
        credit.setRequestDate(dto.getRequestDate());
        credit.setStatus(dto.getStatus());
        credit.setAcceptanceDate(dto.getAcceptanceDate());
        credit.setAmount(dto.getAmount());
        credit.setRepaymentDuration(dto.getRepaymentDuration());
        credit.setInterestRate(dto.getInterestRate());
    }
} 