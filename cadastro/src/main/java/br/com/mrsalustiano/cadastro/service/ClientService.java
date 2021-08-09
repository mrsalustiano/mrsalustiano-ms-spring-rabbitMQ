package br.com.mrsalustiano.cadastro.service;

import br.com.mrsalustiano.cadastro.entity.Client;
import br.com.mrsalustiano.cadastro.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {


    private final ClientRepository repository;

    @Autowired
    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }


    public Client insertClient(Client client) {
      return repository.save(client);
    }

    public Client updateCliente(Client client) {
       Optional<Client> newClient = repository.findById(client.getId());

       if (newClient.isPresent()){
           return repository.save(client);
       } else
       {
           return null;
       }
    }

    public Boolean deleteClient(Long id) {
        Optional<Client> client = repository.findById(id);
        if(client.isPresent()){
            repository.delete(client.get());
            return true;
        }else
        {
            return false;
        }
    }

    public Optional<Client> findById(Long id) {
       return repository.findById(id);

    }










}
