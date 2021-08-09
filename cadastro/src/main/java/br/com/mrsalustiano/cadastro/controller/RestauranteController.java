package br.com.mrsalustiano.cadastro.controller;

import br.com.mrsalustiano.cadastro.dto.RestauranteDTO;
import br.com.mrsalustiano.cadastro.entity.Restaurante;
import br.com.mrsalustiano.cadastro.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/restaurante")
public class RestauranteController {


    private final RestauranteService service;

    @Autowired
    public RestauranteController(RestauranteService service) {
        this.service = service;
    }


    @GetMapping("/health")
    public String health() {
        return "On-Line ";
    }

    @PostMapping("/insert")
    public ResponseEntity insertRestaurants(@RequestBody RestauranteDTO restauranteDTO){


        try {
            return ResponseEntity.ok(service.insertRestaurante(Restaurante.create(restauranteDTO)));
        } catch (Exception e){
           return ResponseEntity.badRequest().body(e.getCause().getCause().getMessage());
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateRestaurants(@PathVariable("id") Long id, @RequestBody RestauranteDTO restauranteDTO) {

        try {

            Restaurante restaurante = Restaurante.create(restauranteDTO);
            restaurante.setId(id);

            restaurante = service.updateRestaurante(restaurante);

            return Objects.nonNull(restaurante) ? ResponseEntity.ok().body(restaurante) :
                    ResponseEntity.status(404).body("Restaurante Inexistente");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getCause().getCause().getMessage());
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteRestaurants(@PathVariable("id") Long id){
        return  service.deleteRestaurante(id) ?
                ResponseEntity.ok().build() :
                ResponseEntity.status(404).body("Restaurante Inexistente");


    }

    @PostMapping("/find/{id}")
    public  ResponseEntity findById(@PathVariable("id") Long id){

       Optional<Restaurante> restaurant =  service.findById(id);

       return  restaurant.isPresent() ?
               ResponseEntity.ok(restaurant.get()) :
               ResponseEntity.status(404).body("Restaurante Inexistente");

    }

}
