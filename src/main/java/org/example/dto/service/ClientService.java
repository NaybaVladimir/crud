package org.example.dto.service;

import lombok.AllArgsConstructor;
import org.example.dto.model.Client;
import org.example.dto.repos.ClientRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class ClientService {

    private ClientRepository clientRepository;

    @Transactional
    public void save(Client client) {
        clientRepository.save(client);
    }
}
