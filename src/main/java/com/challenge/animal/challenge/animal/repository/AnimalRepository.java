package com.challenge.animal.challenge.animal.repository;

import com.challenge.animal.challenge.animal.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    Animal findByNomeContainingIgnoreCase(String animal);
}