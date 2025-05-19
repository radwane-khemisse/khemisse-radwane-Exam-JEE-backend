package sys.radwane.khemisse;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sys.radwane.khemisse.entities.*;
import sys.radwane.khemisse.repositories.*;

import java.util.Date;

@SpringBootApplication
public class KhemisseApplication {

	public static void main(String[] args) {
		SpringApplication.run(KhemisseApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(
			ClientRepository clientRepository,
			CreditRepository creditRepository,
			RemboursementRepository remboursementRepository) {
		
		return args -> {
			Client client = new Client();
			client.setName("Khemisse raddwane");
			client.setEmail("khemisse@gmail.com");
			clientRepository.save(client);

			CreditPersonnel creditPersonnel = new CreditPersonnel();
			creditPersonnel.setRequestDate(new Date());
			creditPersonnel.setStatus(CreditStatus.EN_COURS);
			creditPersonnel.setAmount(50000.0);
			creditPersonnel.setRepaymentDuration(24);
			creditPersonnel.setInterestRate(4.5);
			creditPersonnel.setMotif("Home renovation");
			creditPersonnel.setClient(client);
			creditRepository.save(creditPersonnel);

			CreditImmobilier creditImmobilier = new CreditImmobilier();
			creditImmobilier.setRequestDate(new Date());
			creditImmobilier.setStatus(CreditStatus.ACCEPTE);
			creditImmobilier.setAmount(250000.0);
			creditImmobilier.setRepaymentDuration(120);
			creditImmobilier.setInterestRate(3.2);
			creditImmobilier.setTypeBien(TypeBien.MAISON);
			creditImmobilier.setClient(client);
			creditRepository.save(creditImmobilier);

			Remboursement remboursement = new Remboursement();
			remboursement.setDate(new Date());
			remboursement.setAmount(1200.0);
			remboursement.setType(RemboursementType.MENSUALITE);
			remboursement.setCredit(creditPersonnel);
			remboursementRepository.save(remboursement);
		};
	}

}
