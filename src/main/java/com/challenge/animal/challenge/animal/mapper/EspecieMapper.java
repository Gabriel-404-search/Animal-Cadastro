package com.challenge.animal.challenge.animal.mapper;

import com.challenge.animal.challenge.animal.dto.EspecieDTO;
import com.challenge.animal.challenge.animal.entity.Especie;

public class EspecieMapper {

    public static Especie toEspecie(EspecieDTO especieDTO){
        Especie especie = new Especie();
        especie.setNome(especieDTO.nome());
        return especie;
    }

}
