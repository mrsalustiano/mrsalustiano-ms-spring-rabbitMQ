package br.com.mrsalustiano.cadastro.repository;


import br.com.mrsalustiano.cadastro.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

}
