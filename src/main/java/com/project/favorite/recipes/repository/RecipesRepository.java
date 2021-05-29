package com.project.favorite.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.favorite.recipes.entity.Recipes;

@Repository
public interface RecipesRepository extends JpaRepository<Recipes, Integer> {
	
	Recipes findByRecipesName(String recipesName);
}
