package sys.radwane.khemisse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sys.radwane.khemisse.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
} 