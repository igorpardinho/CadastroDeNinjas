package dev.java10x.cadastrodeninjas.dto;

import dev.java10x.cadastrodeninjas.model.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MissaoDTO {

    private Long id;

    private String name;

    private String description;

    private String difficult;

    private List<NinjaModel> ninjas;
}
