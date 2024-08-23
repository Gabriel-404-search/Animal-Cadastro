package com.challenge.animal.challenge.animal.service;

import com.challenge.animal.challenge.animal.dto.EspecieDTO;
import com.challenge.animal.challenge.animal.mapper.EspecieMapper;
import com.challenge.animal.challenge.animal.repository.EspecieRepository;
import com.challenge.animal.challenge.animal.entity.Especie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EspecieService {
    @Autowired
    EspecieRepository especieRepository
            ;

    public Especie salve(EspecieDTO dto) {
        Especie especie = EspecieMapper.toEspecie(dto);
        especieRepository.save(especie);
        return especie;
    }

    public Especie leiaPeloId(Long id) {
        Optional<Especie> byId = especieRepository.findById(id);
        return byId.orElse(null);
    }

    public void atualizaNome(String nome, Long id) {
        Optional<Especie> especie = especieRepository.findById(id);
        especie.ifPresent(e -> {
            e.setNome(nome);
            especieRepository.save(e);
        });
    }
    public void deletePeloId(Long id){
            especieRepository.deleteById(id);
    }
}