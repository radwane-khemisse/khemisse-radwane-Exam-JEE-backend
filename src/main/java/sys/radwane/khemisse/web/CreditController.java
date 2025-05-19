package sys.radwane.khemisse.web;

import org.springframework.web.bind.annotation.*;
import sys.radwane.khemisse.dtos.*;
import sys.radwane.khemisse.entities.CreditStatus;
import sys.radwane.khemisse.services.CreditService;

import java.util.List;

@RestController
@RequestMapping("/api/credits")
public class CreditController {
    private final CreditService creditService;

    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping
    public List<CreditDTO> getAllCredits() {
        return creditService.getAllCredits();
    }

    @GetMapping("/{id}")
    public CreditDTO getCreditById(@PathVariable Long id) {
        return creditService.getCreditById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCredit(@PathVariable Long id) {
        creditService.deleteCredit(id);
    }

    @PostMapping("/personnel")
    public CreditPersonnelDTO createCreditPersonnel(@RequestBody CreditPersonnelDTO creditDTO) {
        return creditService.saveCreditPersonnel(creditDTO);
    }

    @PostMapping("/immobilier")
    public CreditImmobilierDTO createCreditImmobilier(@RequestBody CreditImmobilierDTO creditDTO) {
        return creditService.saveCreditImmobilier(creditDTO);
    }

    @PostMapping("/professionnel")
    public CreditProfessionnelDTO createCreditProfessionnel(@RequestBody CreditProfessionnelDTO creditDTO) {
        return creditService.saveCreditProfessionnel(creditDTO);
    }

    @GetMapping("/client/{clientId}")
    public List<CreditDTO> getCreditsByClient(@PathVariable Long clientId) {
        return creditService.getCreditsByClientId(clientId);
    }

    @GetMapping("/status/{status}")
    public List<CreditDTO> getCreditsByStatus(@PathVariable CreditStatus status) {
        return creditService.getCreditsByStatus(status);
    }

    @PutMapping("/{id}/status")
    public CreditDTO updateCreditStatus(@PathVariable Long id, @RequestParam CreditStatus newStatus) {
        return creditService.updateCreditStatus(id, newStatus);
    }
} 