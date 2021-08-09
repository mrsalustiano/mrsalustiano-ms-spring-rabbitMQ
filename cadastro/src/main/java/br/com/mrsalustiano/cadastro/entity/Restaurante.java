package br.com.mrsalustiano.cadastro.entity;


import br.com.mrsalustiano.cadastro.dto.RestauranteDTO;
import com.sun.istack.NotNull;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Entity
@Table(name = "tb_restaurante")
@Data
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    @NotNull
    private String nome;

    @Column(nullable = false, length = 80)
    @NotNull
    private String email;

    @Column(nullable = false, length = 200)
    @NotNull
    private String endereco;

    public static Restaurante create(RestauranteDTO restauranteDTO) {
        return new ModelMapper().map(restauranteDTO, Restaurante.class);

    }



}
