package br.com.mrsalustiano.cadastro.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RestauranteDTO {

    private String nome;
    private String email;
    private String endereco;
}
