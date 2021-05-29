package com.project.favorite.recipes.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.favorite.recipes.entity.Ingredients;
import com.project.favorite.recipes.repository.IngredientsRepository;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	IngredientsRepository ingredientsRepository; 

	@Override
	public void run(String... args) throws Exception {

		Ingredients ingredientsA = new Ingredients();
		ingredientsA.setIngredientsName("Tomato");
		
		Ingredients ingredientsB = new Ingredients();
		ingredientsB.setIngredientsName("Onion");
		
		Ingredients ingredientsC = new Ingredients();
		ingredientsC.setIngredientsName("Salt");
		
		/*
		 * ingredientsRepository.save(ingredientsA);
		 * ingredientsRepository.save(ingredientsB);
		 * ingredientsRepository.save(ingredientsC);
		 */
		
	}

}
