package com.challenge.animal.challenge.animal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = ("animal"))
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sexo;
    private String raca;
    private int idade;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Especie especie;

    public Animal(){
        this.id = getId();
        this.nome = getNome();
        this.sexo = getSexo();
        this.raca = getRaca();
        this.idade = getIdade();
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Long getId() {
        return id;
    }

    public long setId(Long id) {
        this.id = id;
        return this.id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}