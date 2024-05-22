package com.example.backend_mysql_test.repository;

import com.example.backend_mysql_test.entity.Client;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@DataJpaTest
public class ClientRepositoryTests {
    @Autowired
    private ClientRepository clientRepository;

    private Client client;

    @BeforeEach
    private void setClientConfiguration(){
        this.client = new Client("First Name","Last Name", new BigDecimal(30.0));
    }

    @Test
    public void saveClient(){
        Client savedClient = clientRepository.save(client);
        Assertions.assertNotNull(savedClient);
        Assertions.assertEquals(savedClient, client);
        Assertions.assertNotNull(savedClient.getId());
    }

    @Test
    public void findAllClients(){
        Faker faker = new Faker();
        int nameQuantity = 5;
        List<String> names = new ArrayList<String>();
        Random rand = new Random();


        for (int x = 0; x < nameQuantity; x++){
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            names.add(firstName);
            BigDecimal participation = BigDecimal.valueOf(nameQuantity * 10);
            Client savedClient = new Client(firstName, lastName, participation);
            clientRepository.save(savedClient);
        }

        int randomPosition = rand.nextInt(nameQuantity);
        List<Client> allClients = clientRepository.findAll();
        String randomName = allClients.get(randomPosition).getFirstName();

        Assertions.assertTrue(names.contains(randomName));
        Assertions.assertEquals(allClients.toArray().length, nameQuantity );
    }
}
