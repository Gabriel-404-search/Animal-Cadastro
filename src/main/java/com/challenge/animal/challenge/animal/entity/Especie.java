package com.challenge.animal.challenge.animal.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = ("especie"))
public class Especie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (unique = true)
    private String nome;

    @OneToMany(mappedBy = "especie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Animal> animalList = new ArrayList<>();

    public Especie(){
        this.id = getId();
        this.nome = getNome();
    }

    public List<Animal> getAnimalList(List<Animal>animalList) {
        animalList.forEach(a-> a.setEspecie(this)); // aqui estamos falando que essa especie, e dona this animal
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
