package sys.radwane.khemisse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sys.radwane.khemisse.entities.Remboursement;
import sys.radwane.khemisse.entities.RemboursementType;

import java.util.Date;
import java.util.List;

@Repository
public interface RemboursementRepository extends JpaRepository<Remboursement, Long> {
    List<Remboursement> findByCreditId(Long creditId);
    List<Remboursement> findByType(RemboursementType type);
    List<Remboursement> findByDateBetween(Date startDate, Date endDate);
} 