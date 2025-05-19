package sys.radwane.khemisse.web;

import org.springframework.web.bind.annotation.*;
import sys.radwane.khemisse.dtos.RemboursementDTO;
import sys.radwane.khemisse.entities.RemboursementType;
import sys.radwane.khemisse.services.RemboursementService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/remboursements")
public class RemboursementController {
    private final RemboursementService remboursementService;

    public RemboursementController(RemboursementService remboursementService) {
        this.remboursementService = remboursementService;
    }

    @GetMapping
    public List<RemboursementDTO> getAllRemboursements() {
        return remboursementService.getAllRemboursements();
    }

    @GetMapping("/{id}")
    public RemboursementDTO getRemboursementById(@PathVariable Long id) {
        return remboursementService.getRemboursementById(id);
    }

    @PostMapping
    public RemboursementDTO createRemboursement(@RequestBody RemboursementDTO remboursementDTO) {
        return remboursementService.saveRemboursement(remboursementDTO);
    }

    @PutMapping("/{id}")
    public RemboursementDTO updateRemboursement(@PathVariable Long id, @RequestBody RemboursementDTO remboursementDTO) {
        remboursementDTO.setId(id);
        return remboursementService.updateRemboursement(remboursementDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRemboursement(@PathVariable Long id) {
        remboursementService.deleteRemboursement(id);
    }

    @GetMapping("/credit/{creditId}")
    public List<RemboursementDTO> getRemboursementsByCredit(@PathVariable Long creditId) {
        return remboursementService.getRemboursementsByCreditId(creditId);
    }

    @GetMapping("/type/{type}")
    public List<RemboursementDTO> getRemboursementsByType(@PathVariable RemboursementType type) {
        return remboursementService.getRemboursementsByType(type);
    }

    @GetMapping("/date-range")
    public List<RemboursementDTO> getRemboursementsByDateRange(
            @RequestParam Date startDate,
            @RequestParam Date endDate) {
        return remboursementService.getRemboursementsByDateRange(startDate, endDate);
    }

    @GetMapping("/credit/{creditId}/total")
    public Double getTotalRemboursementAmountForCredit(@PathVariable Long creditId) {
        return remboursementService.getTotalRemboursementAmountForCredit(creditId);
    }
} 