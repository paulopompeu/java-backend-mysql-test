package com.example.backend_mysql_test.controller;

import com.example.backend_mysql_test.entity.Client;
import com.example.backend_mysql_test.entity.dto.ClientDTO;
import com.example.backend_mysql_test.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/save")
    public ResponseEntity<Client> saveClient(@RequestBody ClientDTO clientDTO){
        Client client = clientService.saveClient(clientDTO);
        return ResponseEntity.ok().body(client);
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Client>> listAllClients(){
        List<Client> clientList = clientService.listAllClients();
        return ResponseEntity.ok().body(clientList);
    }
}
