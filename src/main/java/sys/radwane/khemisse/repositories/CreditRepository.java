package sys.radwane.khemisse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sys.radwane.khemisse.entities.Credit;
import sys.radwane.khemisse.entities.CreditStatus;

import java.util.List;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {

} 