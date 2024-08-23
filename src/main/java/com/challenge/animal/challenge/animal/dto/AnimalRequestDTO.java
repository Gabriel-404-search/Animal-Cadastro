package com.challenge.animal.challenge.animal.dto;

public record AnimalRequestDTO(String nome, String sexo,
                               String raca,
                               int idade,
                               Long especieId) {}