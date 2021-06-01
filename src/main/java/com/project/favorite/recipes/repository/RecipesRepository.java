package com.project.favorite.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.favorite.recipes.entity.Recipes;

/**
 * {@link RecipesRepository}
 * 
 * Recipes repository is created to use JPA functionality and use to perform CRUD operations on the table
 * 
 * @author Sumit.Vaidya
 *
 */
@Repository
public interface RecipesRepository extends JpaRepository<Recipes, Integer> {
	
	Recipes findByRecipesName(String recipesName);
}
