package com.example.backend_mysql_test.service;

import com.example.backend_mysql_test.entity.Client;
import com.example.backend_mysql_test.entity.dto.ClientDTO;
import com.example.backend_mysql_test.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client saveClient(ClientDTO clientDTO) {

        Client client = new Client();
        client.setFirstName(clientDTO.firstName());
        client.setLastName(clientDTO.lastName());
        client.setParticipation((clientDTO.participation()));

        System.out.println(client.getFirstName());
        System.out.println(client.getLastName());
        if (client.getFirstName() == null || client.getLastName() == null) {

            throw new NullPointerException();
        }

        return clientRepository.save(client);
    }

    public List<Client> listAllClients() {
        List<Client> allClients = clientRepository.findAll();

        if (allClients.isEmpty()) {
            throw new NullPointerException();
        }

        return allClients;
    }

}
