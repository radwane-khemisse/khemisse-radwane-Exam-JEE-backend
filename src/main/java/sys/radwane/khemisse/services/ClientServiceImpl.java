package sys.radwane.khemisse.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sys.radwane.khemisse.dtos.ClientDTO;
import sys.radwane.khemisse.entities.Client;
import sys.radwane.khemisse.mappers.ClientMapper;
import sys.radwane.khemisse.repositories.ClientRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;
    private ClientMapper clientMapper;

    @Override
    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(clientMapper::fromClient)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
        return clientMapper.fromClient(client);
    }

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = clientMapper.fromClientDTO(clientDTO);
        Client savedClient = clientRepository.save(client);
        return clientMapper.fromClient(savedClient);
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        // Verify client exists
        clientRepository.findById(clientDTO.getId())
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + clientDTO.getId()));
        
        Client client = clientMapper.fromClientDTO(clientDTO);
        Client updatedClient = clientRepository.save(client);
        return clientMapper.fromClient(updatedClient);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<ClientDTO> searchClientsByName(String name) {
        List<Client> clients = clientRepository.findAll().stream()
                .filter(client -> client.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
                
        return clients.stream()
                .map(clientMapper::fromClient)
                .collect(Collectors.toList());
    }
} 