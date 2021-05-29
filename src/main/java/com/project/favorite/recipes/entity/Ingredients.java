package com.project.favorite.recipes.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.project.favorite.recipes.converter.LocalDateTimeConverter;

@Entity
public class Ingredients {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ingredientId", updatable = false, nullable = false)
	private Integer ingredientId;
	
	@Column(length = 25)
	private String ingredientsName;
	
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime createdAt;
	
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime updatedAt;
	
	
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


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}


	@Override
	public String toString() {
		return "Ingredients [ingredientId=" + ingredientId + ", ingredientsName=" + ingredientsName + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
}
