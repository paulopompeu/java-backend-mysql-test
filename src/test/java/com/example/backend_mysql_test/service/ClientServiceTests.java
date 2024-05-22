package com.example.backend_mysql_test.service;

import com.example.backend_mysql_test.entity.Client;
import com.example.backend_mysql_test.entity.dto.ClientDTO;
import com.example.backend_mysql_test.repository.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTests {
    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    private Client client;
    private ClientDTO clientDTO;

    @BeforeEach
    private void setup(){
        client = new Client(2L,"Bhaltazar","Oliveira", new BigDecimal(80));
        clientDTO = new ClientDTO("Bhaltazar", "Oliveira", new BigDecimal(80));
    }

    @Test
    public void saveClient(){

        when(this.clientRepository.save(ArgumentMatchers.any(Client.class))).thenReturn(client);

        Client clientSaved = clientService.saveClient(clientDTO);

    }

    @Test
    public void findAllClients(){
        List<Client> clientList = new ArrayList<>();
        clientList.add(client);
        clientList.add(client);
        clientList.add(client);

        when(this.clientRepository.findAll()).thenReturn(clientList);

        List<Client> clientListMock = clientService.listAllClients();
        Assertions.assertNotNull(clientListMock);
        Assertions.assertNotNull(clientListMock.get(0).getId());
        Assertions.assertEquals(clientListMock.toArray().length,3);

    }
}
