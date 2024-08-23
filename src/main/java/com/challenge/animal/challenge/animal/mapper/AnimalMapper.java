package com.challenge.animal.challenge.animal.mapper;

import com.challenge.animal.challenge.animal.dto.AnimalRequestDTO;
import com.challenge.animal.challenge.animal.dto.AnimalResponseDTO;
import com.challenge.animal.challenge.animal.entity.Animal;
import com.challenge.animal.challenge.animal.entity.Especie;

public class AnimalMapper {

    public static Animal toEntity(AnimalRequestDTO animalRequestDTO, Especie especie){
        Animal animal = new Animal();
        animal.setNome(animalRequestDTO.nome());
        animal.setRaca(animalRequestDTO.raca());
        animal.setSexo(animalRequestDTO.sexo());
        animal.setIdade(animalRequestDTO.idade());
        animal.setEspecie(especie);
        return animal;
    }
    public static AnimalResponseDTO toDto(Animal animal){
        String nomeEspecie = null;
        if (animal.getEspecie() != null){
            nomeEspecie = animal.getEspecie().getNome();
        }
            return new AnimalResponseDTO(animal.getNome(), animal.getSexo(),
                    animal.getRaca(), animal.getIdade(), nomeEspecie);
    }
}