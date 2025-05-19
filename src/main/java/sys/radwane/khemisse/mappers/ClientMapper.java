package sys.radwane.khemisse.mappers;

import org.springframework.stereotype.Service;
import sys.radwane.khemisse.dtos.ClientDTO;
import sys.radwane.khemisse.entities.Client;

@Service
public class ClientMapper {

    public ClientDTO fromClient(Client client) {
        if (client == null) return null;
        
        return ClientDTO.builder()
                .id(client.getId())
                .name(client.getName())
                .email(client.getEmail())
                .build();
    }

    public Client fromClientDTO(ClientDTO clientDTO) {
        if (clientDTO == null) return null;
        
        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setName(clientDTO.getName());
        client.setEmail(clientDTO.getEmail());
        return client;
    }
} 