package com.challenge.animal.challenge.animal.controller;

import com.challenge.animal.challenge.animal.dto.EspecieDTO;
import com.challenge.animal.challenge.animal.entity.Especie;
import com.challenge.animal.challenge.animal.service.EspecieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/especie")
public class EspecieController {

    public final EspecieService especieService;
    public EspecieController(EspecieService especieService) {
        this.especieService = especieService;
    }

    @GetMapping("/{id}")
    public Especie pegar(@PathVariable("id") Long id){
        Especie especie = especieService.leiaPeloId(id);
        return ResponseEntity.ok(especie).getBody();
    }
    @PostMapping
    public Especie salve(@RequestBody EspecieDTO especieDTO) {
        Especie especie = especieService.salve(especieDTO);
        return ResponseEntity.ok(especie).getBody();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@RequestParam("nome") String nome, @PathVariable("id") Long id){
        especieService.atualizaNome(nome, id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleting(@PathVariable("id") Long id){
        especieService.deletePeloId(id);
        return ResponseEntity.ok().build();
    }
}
