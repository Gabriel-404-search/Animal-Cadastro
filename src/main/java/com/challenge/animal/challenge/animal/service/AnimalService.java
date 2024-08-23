package com.challenge.animal.challenge.animal.service;

import com.challenge.animal.challenge.animal.dto.AnimalRequestDTO;
import com.challenge.animal.challenge.animal.dto.AnimalResponseDTO;
import com.challenge.animal.challenge.animal.entity.Animal;
import com.challenge.animal.challenge.animal.entity.Especie;
import com.challenge.animal.challenge.animal.mapper.AnimalMapper;
import com.challenge.animal.challenge.animal.repository.AnimalRepository;
import com.challenge.animal.challenge.animal.repository.EspecieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {


    private final AnimalRepository animalRepository;
    private final EspecieRepository especieRepository;

    public AnimalService(AnimalRepository repository, EspecieRepository especieRepository) {
        this.animalRepository = repository;
        this.especieRepository = especieRepository;
    }

    public void salve(AnimalRequestDTO animal){
        Optional<Especie> especie = especieRepository.findById(animal.especieId());
        especie.ifPresent(e->{
            Animal entity = AnimalMapper.toEntity(animal, e);
            animalRepository.save(entity);
        });
    }
    public AnimalResponseDTO leiaPeloNome(String nome){
        Animal animal = animalRepository.findByNomeContainingIgnoreCase(nome);
        return AnimalMapper.toDto(animal);
    }

     public void atualizaIdade(Integer idade, Long id){
         Optional<Animal> animal = animalRepository.findById(id);
         animal.ifPresent(a->{
             a.setIdade(idade);
             animalRepository.save(a);
         });
    }
    public void deleteById(Long id){
        animalRepository.deleteById(id);
    }

    public List<Animal> findAll(){
        return animalRepository.findAll();
    }
}