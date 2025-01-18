package dev.java10x.cadastrodeninjas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 24, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String description;

    @Column(length = 1, nullable = false)
    private String difficult;


    @JsonIgnore
    @OneToMany(mappedBy = "missao")
    private List<NinjaModel> ninjas;


}
