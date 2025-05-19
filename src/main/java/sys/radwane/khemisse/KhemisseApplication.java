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
			// Create multiple clients
			Client client1 = new Client();
			client1.setName("Radwane Khemisse");
			client1.setEmail("radwane.khemisse@example.com");
			clientRepository.save(client1);

			Client client2 = new Client();
			client2.setName("Bilal Ahmed");
			client2.setEmail("bilal.ahmed@example.com");
			clientRepository.save(client2);

			Client client3 = new Client();
			client3.setName("Youssef Ali");
			client3.setEmail("youssef.ali@example.com");
			clientRepository.save(client3);

			Client client4 = new Client();
			client4.setName("Amine Hassan");
			client4.setEmail("amine.hassan@example.com");
			clientRepository.save(client4);

			Client client5 = new Client();
			client5.setName("Karim Mohamed");
			client5.setEmail("karim.mohamed@example.com");
			clientRepository.save(client5);

			// Create multiple credits
			CreditPersonnel creditPersonnel1 = new CreditPersonnel();
			creditPersonnel1.setRequestDate(new Date());
			creditPersonnel1.setStatus(CreditStatus.EN_COURS);
			creditPersonnel1.setAmount(50000.0);
			creditPersonnel1.setRepaymentDuration(24);
			creditPersonnel1.setInterestRate(4.5);
			creditPersonnel1.setMotif("Home renovation");
			creditPersonnel1.setClient(client1);
			creditRepository.save(creditPersonnel1);

			CreditImmobilier creditImmobilier1 = new CreditImmobilier();
			creditImmobilier1.setRequestDate(new Date());
			creditImmobilier1.setStatus(CreditStatus.ACCEPTE);
			creditImmobilier1.setAmount(250000.0);
			creditImmobilier1.setRepaymentDuration(120);
			creditImmobilier1.setInterestRate(3.2);
			creditImmobilier1.setTypeBien(TypeBien.MAISON);
			creditImmobilier1.setClient(client2);
			creditRepository.save(creditImmobilier1);

			CreditProfessionnel creditProfessionnel1 = new CreditProfessionnel();
			creditProfessionnel1.setRequestDate(new Date());
			creditProfessionnel1.setStatus(CreditStatus.EN_COURS);
			creditProfessionnel1.setAmount(100000.0);
			creditProfessionnel1.setRepaymentDuration(60);
			creditProfessionnel1.setInterestRate(5.0);
			creditProfessionnel1.setMotif("Business expansion");
			creditProfessionnel1.setRaisonSociale("Khemisse Corp");
			creditProfessionnel1.setClient(client3);
			creditRepository.save(creditProfessionnel1);

			CreditPersonnel creditPersonnel2 = new CreditPersonnel();
			creditPersonnel2.setRequestDate(new Date());
			creditPersonnel2.setStatus(CreditStatus.REJETE);
			creditPersonnel2.setAmount(30000.0);
			creditPersonnel2.setRepaymentDuration(12);
			creditPersonnel2.setInterestRate(6.0);
			creditPersonnel2.setMotif("Car purchase");
			creditPersonnel2.setClient(client4);
			creditRepository.save(creditPersonnel2);

			CreditImmobilier creditImmobilier2 = new CreditImmobilier();
			creditImmobilier2.setRequestDate(new Date());
			creditImmobilier2.setStatus(CreditStatus.ACCEPTE);
			creditImmobilier2.setAmount(150000.0);
			creditImmobilier2.setRepaymentDuration(84);
			creditImmobilier2.setInterestRate(3.5);
			creditImmobilier2.setTypeBien(TypeBien.APPARTEMENT);
			creditImmobilier2.setClient(client5);
			creditRepository.save(creditImmobilier2);

			// Create multiple repayments
			Remboursement remboursement1 = new Remboursement();
			remboursement1.setDate(new Date());
			remboursement1.setAmount(1200.0);
			remboursement1.setType(RemboursementType.MENSUALITE);
			remboursement1.setCredit(creditPersonnel1);
			remboursementRepository.save(remboursement1);

			Remboursement remboursement2 = new Remboursement();
			remboursement2.setDate(new Date());
			remboursement2.setAmount(2500.0);
			remboursement2.setType(RemboursementType.MENSUALITE);
			remboursement2.setCredit(creditImmobilier1);
			remboursementRepository.save(remboursement2);

			Remboursement remboursement3 = new Remboursement();
			remboursement3.setDate(new Date());
			remboursement3.setAmount(5000.0);
			remboursement3.setType(RemboursementType.REMBOURSEMENT_ANTICIPE);
			remboursement3.setCredit(creditProfessionnel1);
			remboursementRepository.save(remboursement3);

			Remboursement remboursement4 = new Remboursement();
			remboursement4.setDate(new Date());
			remboursement4.setAmount(800.0);
			remboursement4.setType(RemboursementType.MENSUALITE);
			remboursement4.setCredit(creditPersonnel2);
			remboursementRepository.save(remboursement4);

			Remboursement remboursement5 = new Remboursement();
			remboursement5.setDate(new Date());
			remboursement5.setAmount(1800.0);
			remboursement5.setType(RemboursementType.MENSUALITE);
			remboursement5.setCredit(creditImmobilier2);
			remboursementRepository.save(remboursement5);
		};
	}

}
