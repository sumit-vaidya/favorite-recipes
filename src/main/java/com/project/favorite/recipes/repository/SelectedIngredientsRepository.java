package com.project.favorite.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.favorite.recipes.entity.SelectedIngredients;

@Repository
public interface SelectedIngredientsRepository extends JpaRepository<SelectedIngredients, Integer> {

}
