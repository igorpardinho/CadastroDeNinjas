package dev.java10x.cadastrodeninjas.dto;

import dev.java10x.cadastrodeninjas.model.MissaoModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NinjaDTO {

    private Long id;

    private String name;

    private String email;

    private int idade;

    private String rank;

    private MissaoModel missao;

}
