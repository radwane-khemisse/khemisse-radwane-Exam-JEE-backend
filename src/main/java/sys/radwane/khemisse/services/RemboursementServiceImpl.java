package sys.radwane.khemisse.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sys.radwane.khemisse.dtos.RemboursementDTO;
import sys.radwane.khemisse.entities.Credit;
import sys.radwane.khemisse.entities.Remboursement;
import sys.radwane.khemisse.entities.RemboursementType;
import sys.radwane.khemisse.mappers.RemboursementMapper;
import sys.radwane.khemisse.repositories.CreditRepository;
import sys.radwane.khemisse.repositories.RemboursementRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class RemboursementServiceImpl implements RemboursementService {
    private RemboursementRepository remboursementRepository;
    private CreditRepository creditRepository;
    private RemboursementMapper remboursementMapper;

    @Override
    public List<RemboursementDTO> getAllRemboursements() {
        List<Remboursement> remboursements = remboursementRepository.findAll();
        return remboursements.stream()
                .map(remboursementMapper::fromRemboursement)
                .collect(Collectors.toList());
    }

    @Override
    public RemboursementDTO getRemboursementById(Long id) {
        Remboursement remboursement = remboursementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Remboursement not found with id: " + id));
        return remboursementMapper.fromRemboursement(remboursement);
    }

    @Override
    public RemboursementDTO saveRemboursement(RemboursementDTO remboursementDTO) {
        Credit credit = getCreditForRemboursement(remboursementDTO.getCreditId());
        Remboursement remboursement = remboursementMapper.fromRemboursementDTO(remboursementDTO, credit);
        Remboursement savedRemboursement = remboursementRepository.save(remboursement);
        return remboursementMapper.fromRemboursement(savedRemboursement);
    }

    @Override
    public RemboursementDTO updateRemboursement(RemboursementDTO remboursementDTO) {
        // Verify remboursement exists
        remboursementRepository.findById(remboursementDTO.getId())
                .orElseThrow(() -> new RuntimeException("Remboursement not found with id: " + remboursementDTO.getId()));
        
        Credit credit = getCreditForRemboursement(remboursementDTO.getCreditId());
        Remboursement remboursement = remboursementMapper.fromRemboursementDTO(remboursementDTO, credit);
        Remboursement updatedRemboursement = remboursementRepository.save(remboursement);
        return remboursementMapper.fromRemboursement(updatedRemboursement);
    }

    @Override
    public void deleteRemboursement(Long id) {
        remboursementRepository.deleteById(id);
    }

    @Override
    public List<RemboursementDTO> getRemboursementsByCreditId(Long creditId) {
        List<Remboursement> remboursements = remboursementRepository.findByCreditId(creditId);
        return remboursements.stream()
                .map(remboursementMapper::fromRemboursement)
                .collect(Collectors.toList());
    }

    @Override
    public List<RemboursementDTO> getRemboursementsByType(RemboursementType type) {
        List<Remboursement> remboursements = remboursementRepository.findByType(type);
        return remboursements.stream()
                .map(remboursementMapper::fromRemboursement)
                .collect(Collectors.toList());
    }

    @Override
    public List<RemboursementDTO> getRemboursementsByDateRange(Date startDate, Date endDate) {
        List<Remboursement> remboursements = remboursementRepository.findByDateBetween(startDate, endDate);
        return remboursements.stream()
                .map(remboursementMapper::fromRemboursement)
                .collect(Collectors.toList());
    }

    @Override
    public Double getTotalRemboursementAmountForCredit(Long creditId) {
        List<Remboursement> remboursements = remboursementRepository.findByCreditId(creditId);
        return remboursements.stream()
                .mapToDouble(Remboursement::getAmount)
                .sum();
    }
    
    // Helper method to get the credit for a remboursement
    private Credit getCreditForRemboursement(Long creditId) {
        return creditRepository.findById(creditId)
                .orElseThrow(() -> new RuntimeException("Credit not found with id: " + creditId));
    }
} 