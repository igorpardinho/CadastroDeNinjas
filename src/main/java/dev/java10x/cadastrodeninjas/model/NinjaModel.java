package dev.java10x.cadastrodeninjas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 24,nullable = false)
    private String name;

    @Column(length = 70, unique = true)
    private String email;

    @Column(nullable = false)
    private int idade;

    private String rank;

    @ManyToOne
    @JoinColumn(name = "missao_id")
    private MissaoModel missao;


}
