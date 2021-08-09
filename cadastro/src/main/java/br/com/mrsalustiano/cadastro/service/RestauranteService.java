package br.com.mrsalustiano.cadastro.service;

import br.com.mrsalustiano.cadastro.entity.Restaurante;
import br.com.mrsalustiano.cadastro.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestauranteService {


    private final RestauranteRepository repository;

    @Autowired
    public RestauranteService(RestauranteRepository repository) {
        this.repository = repository;
    }


    public Restaurante insertRestaurante(Restaurante restaurante) {
      return repository.save(restaurante);
    }

    public Restaurante updateRestaurante(Restaurante restaurante) {
       Optional<Restaurante> newRestaurante = repository.findById(restaurante.getId());

       if (newRestaurante.isPresent()){
           return repository.save(restaurante);
       } else
       {
           return null;
       }
    }

    public Boolean deleteRestaurante(Long id) {
        Optional<Restaurante> restaurante = repository.findById(id);
        if(restaurante.isPresent()){
            repository.delete(restaurante.get());
            return true;
        }else
        {
            return false;
        }
    }

    public Optional<Restaurante> findById(Long id) {
       return repository.findById(id);

    }










}
