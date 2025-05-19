package sys.radwane.khemisse.web;

import org.springframework.web.bind.annotation.*;
import sys.radwane.khemisse.dtos.ClientDTO;
import sys.radwane.khemisse.services.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ClientDTO getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    public ClientDTO createClient(@RequestBody ClientDTO clientDTO) {
        return clientService.saveClient(clientDTO);
    }

    @PutMapping("/{id}")
    public ClientDTO updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        clientDTO.setId(id);
        return clientService.updateClient(clientDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

    @GetMapping("/search")
    public List<ClientDTO> searchClientsByName(@RequestParam String name) {
        return clientService.searchClientsByName(name);
    }
} 