package com.challenge.animal;

import com.challenge.animal.challenge.animal.service.AnimalService;
import com.challenge.animal.challenge.animal.service.EspecieService;
import com.challenge.animal.challenge.animal.entity.Animal;
import com.challenge.animal.challenge.animal.entity.Especie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnimalChallengeApplication implements CommandLineRunner {

	@Autowired
	public final AnimalService animalService;
	public final EspecieService especieService;

	public AnimalChallengeApplication(AnimalService animalService, EspecieService especieService){
		this.animalService = animalService;
        this.especieService = especieService;
    }

	public static void main(String[] args) {
		SpringApplication.run(AnimalChallengeApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
//		Animal animal = new Animal();
//		Especie especie = new Especie();

//		especie.setNome("Inseto");
//		Especie especie1 = especieService.salve(especie);
//
//		//Criando um animal vinculado a uma espécie
//		animal.setEspecie(especie1);
//		animal.setSexo("M");
//		animal.setRaca("Barata");
//		animal.setNome("Tata werneck");
//		animal.setIdade(207);
//		animalService.salve(animal);
//
//		especieService.atualizaNome("Peixe", 2L);
//		Animal animalEncontrado = animalService.leiaPeloNome("fiuk");
//		System.out.println(animalEncontrado.getSexo());
//		animalService.deleteById(3L);
//		especieService.atualizaNome("abelha", 7L);
	}
}