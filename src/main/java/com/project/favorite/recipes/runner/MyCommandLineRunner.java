package com.project.favorite.recipes.runner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.favorite.recipes.entity.Ingredients;
import com.project.favorite.recipes.entity.Recipes;
import com.project.favorite.recipes.entity.SelectedIngredients;
import com.project.favorite.recipes.repository.IngredientsRepository;
import com.project.favorite.recipes.repository.RecipesRepository;

/**
 * {@link MyCommandLineRunner}
 * 
 * My command line runner is use to store recipe and other ingredients data for testing
 * 
 * @author Sumit.Vaidya
 *
 */
@Component
public class MyCommandLineRunner implements CommandLineRunner {

	@Autowired
	private IngredientsRepository ingredientsRepository;

	@Autowired
	private RecipesRepository recipesRepository;

	@Override
	public void run(String... args) throws Exception {

		Ingredients ingredientsA = new Ingredients();
		ingredientsA.setIngredientsName("Tomato");
		ingredientsA.setCreatedAt(LocalDateTime.now());
		ingredientsA.setUpdatedAt(LocalDateTime.now());

		Ingredients ingredientsB = new Ingredients();
		ingredientsB.setIngredientsName("Onion");
		ingredientsB.setCreatedAt(LocalDateTime.now());
		ingredientsB.setUpdatedAt(LocalDateTime.now());

		Ingredients ingredientsC = new Ingredients();
		ingredientsC.setIngredientsName("Salt");
		ingredientsC.setCreatedAt(LocalDateTime.now());
		ingredientsC.setUpdatedAt(LocalDateTime.now());

		//ingredientsRepository.save(ingredientsA);
		//ingredientsRepository.save(ingredientsB);
		//ingredientsRepository.save(ingredientsC);

		Recipes recipes = new Recipes();
		recipes.setRecipesName("Veg Biryani");
		recipes.setRecipesType("Veg");
		recipes.setNoOfPerson(2);
		recipes.setCreatedAt(LocalDateTime.now());
		recipes.setUpdatedAt(LocalDateTime.now());
		recipes.setCookingInstruction("1. Take rice"
				+ "2. Take an oil");
		List<SelectedIngredients> SelectedList = new ArrayList<SelectedIngredients>();
		SelectedIngredients selectedA = new SelectedIngredients();
		selectedA.setSelectedIngredientId(1);
		selectedA.setSelectedIngredientsName("Tomato");
		SelectedList.add(selectedA);

		SelectedIngredients selectedB = new SelectedIngredients();
		selectedB.setSelectedIngredientId(2);
		selectedB.setSelectedIngredientsName("Onion");
		SelectedList.add(selectedB);

		SelectedIngredients selectedC = new SelectedIngredients();
		selectedC.setSelectedIngredientId(3);
		selectedC.setSelectedIngredientsName("Salt");
		SelectedList.add(selectedC);

		recipes.setSelectedIngredients(SelectedList);

		//recipesRepository.save(recipes);
	}

}
