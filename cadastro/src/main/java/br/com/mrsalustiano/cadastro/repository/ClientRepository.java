package br.com.mrsalustiano.cadastro.repository;

import br.com.mrsalustiano.cadastro.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
