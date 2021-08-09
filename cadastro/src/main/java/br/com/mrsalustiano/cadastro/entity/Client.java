package br.com.mrsalustiano.cadastro.entity;

import br.com.mrsalustiano.cadastro.dto.ClienteDTO;
import com.sun.istack.NotNull;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.ui.ModelMap;

import javax.persistence.*;

@Entity
@Table(name = "tb_cliente")
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    @NotNull
    private String nome;

    @Column(nullable = false, length = 80)
    @NotNull
    private String email;

    @Column(nullable = false, length = 12)
    @NotNull
    private String password;

    public static Client create(ClienteDTO clienteDTO) {
        return new ModelMapper().map(clienteDTO, Client.class);

    }



}
