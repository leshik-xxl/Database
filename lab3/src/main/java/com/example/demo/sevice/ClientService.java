package com.example.demo.sevice;

import com.example.demo.model.domain.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void add(Client client) {
        clientRepository.saveAndFlush(client);
    }

    public Client findById(Long id) throws Exception {
        return clientRepository.findById(id).orElseThrow(() -> new Exception("Не существует записи с данным id - " + id));
    }

    public void deleteById(Long id){
        clientRepository.deleteById(id);
    }

    public void setClientEMail(String id, String newEMail){
        clientRepository.setClientEMail(Long.parseLong(id), newEMail);
    }

}
