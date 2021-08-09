package br.com.mrsalustiano.cadastro.controller;

import br.com.mrsalustiano.cadastro.dto.ClienteDTO;
import br.com.mrsalustiano.cadastro.entity.Client;
import br.com.mrsalustiano.cadastro.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/cliente")
public class ClienteController {


    private final ClientService clientService;

    @Autowired
    public ClienteController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping("/health")
    public String health() {
        return "On-Line ";
    }

    @PostMapping("/insert")
    public ResponseEntity insertClients(@RequestBody ClienteDTO clienteDTO){


        try {
            return ResponseEntity.ok(clientService.insertClient(Client.create(clienteDTO)));
        } catch (Exception e){
           return ResponseEntity.badRequest().body(e.getCause().getCause().getMessage());
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateClient(@PathVariable("id") Long id, @RequestBody ClienteDTO clienteDTO) {

        try {

            Client client = Client.create(clienteDTO);
            client.setId(id);

            client = clientService.updateCliente(client);

            return Objects.nonNull(client) ? ResponseEntity.ok().body(client) :
                    ResponseEntity.status(404).body("Cliente Inexistente");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteClient(@PathVariable("id") Long id){
        return  clientService.deleteClient(id) ?
                ResponseEntity.ok().build() :
                ResponseEntity.status(404).body("Cliente Inexistente");


    }

    @PostMapping("/find/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){

       Optional<Client> client =  clientService.findById(id);

       return  client.isPresent() ?
               ResponseEntity.ok(client.get()) :
               ResponseEntity.status(404).body("Cliente Inexistente");

    }

}
