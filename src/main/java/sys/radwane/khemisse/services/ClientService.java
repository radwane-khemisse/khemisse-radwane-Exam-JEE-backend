package sys.radwane.khemisse.services;

import sys.radwane.khemisse.dtos.ClientDTO;

import java.util.List;

public interface ClientService {
    List<ClientDTO> getAllClients();
    ClientDTO getClientById(Long id);
    ClientDTO saveClient(ClientDTO clientDTO);
    ClientDTO updateClient(ClientDTO clientDTO);
    void deleteClient(Long id);
    
    List<ClientDTO> searchClientsByName(String name);
} 