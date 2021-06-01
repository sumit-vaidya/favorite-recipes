package com.project.favorite.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.favorite.recipes.entity.Ingredients;

/**
 * {@link IngredientsRepository}
 * 
 * Ingredients repository interface is created to use JPA functionality and use to perform CRUD operations on the table
 * 
 * @author Sumit.Vaidya
 *
 */
@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients, Integer> {
	
	Ingredients  findByIngredientsName(String ingredientsName);
}
