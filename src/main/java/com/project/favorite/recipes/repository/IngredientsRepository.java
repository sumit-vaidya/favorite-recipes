package com.project.favorite.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.favorite.recipes.entity.Ingredients;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients, Integer> {

}
