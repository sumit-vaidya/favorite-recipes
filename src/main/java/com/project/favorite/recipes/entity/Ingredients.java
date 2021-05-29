package com.project.favorite.recipes.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ingredients {
	@Id
	private Integer ingredientId;
	
	@Column(length = 25)
	private String ingredientsName;
	
	private LocalDate createdAt;
	
	private LocalDate updatedAt;
	
	
	public Integer getIngredientId() {
		return ingredientId;
	}


	public void setIngredientId(Integer ingredientId) {
		this.ingredientId = ingredientId;
	}


	public String getIngredientsName() {
		return ingredientsName;
	}


	public void setIngredientsName(String ingredientsName) {
		this.ingredientsName = ingredientsName;
	}


	public LocalDate getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}


	public LocalDate getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}


	@Override
	public String toString() {
		return "Ingredients [ingredientId=" + ingredientId + ", ingredientsName=" + ingredientsName + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
}
