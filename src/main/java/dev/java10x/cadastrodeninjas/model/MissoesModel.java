package dev.java10x.cadastrodeninjas.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String description;

    private String difficult;



    @OneToMany(mappedBy = "missao")
    private List<NinjaModel> ninjas;

    public MissoesModel() {

    }

    public MissoesModel(Long id, String nome, String description, String difficult) {
        this.id = id;
        this.nome = nome;
        this.description = description;
        this.difficult = difficult;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDifficult() {
        return difficult;
    }

    public void setDifficult(String difficult) {
        this.difficult = difficult;
    }
}
