package com.challenge.animal.challenge.animal.repository;

import com.challenge.animal.challenge.animal.entity.Especie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Long> {
}