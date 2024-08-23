package com.challenge.animal.challenge.animal.controller;

import com.challenge.animal.challenge.animal.dto.AnimalRequestDTO;
import com.challenge.animal.challenge.animal.dto.AnimalResponseDTO;
import com.challenge.animal.challenge.animal.entity.Especie;
import com.challenge.animal.challenge.animal.service.AnimalService;
import com.challenge.animal.challenge.animal.service.EspecieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    public final AnimalService animalService;
    public final EspecieService especieService;

    public AnimalController(AnimalService animalService, EspecieService especieService) {
        this.animalService = animalService;
        this.especieService = especieService;
    }

    @GetMapping
    public ResponseEntity<AnimalResponseDTO> mostrar(@RequestParam("nome") String nome){
        AnimalResponseDTO animal = animalService.leiaPeloNome(nome);
        return ResponseEntity.ok(animal);
    }

    @PostMapping
    public ResponseEntity<Void> post(@RequestBody AnimalRequestDTO animalRequestDTO){
        animalService.salve(animalRequestDTO);
        return ResponseEntity.ok().build();
    }
    //retornar um codigo de sucesso

    @PutMapping ("/{id}")
    public ResponseEntity<Object> update(@RequestParam("idade") int idade, @PathVariable("id") Long id){
        animalService.atualizaIdade(idade, id);
        return ResponseEntity.noContent().build();//no content - 204
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleting(@PathVariable("id") Long id){
        animalService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
