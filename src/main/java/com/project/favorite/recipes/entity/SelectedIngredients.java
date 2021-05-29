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
public class SelectedIngredients {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "selectedIngredientId", updatable = false, nullable = false)
	private Integer selectedIngredientId;
	
	@Column(length = 25)
	private String selectedIngredientsName;
	
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime createdAt;
	
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime updatedAt;

	public Integer getSelectedIngredientId() {
		return selectedIngredientId;
	}

	public void setSelectedIngredientId(Integer selectedIngredientId) {
		this.selectedIngredientId = selectedIngredientId;
	}

	public String getSelectedIngredientsName() {
		return selectedIngredientsName;
	}

	public void setSelectedIngredientsName(String selectedIngredientsName) {
		this.selectedIngredientsName = selectedIngredientsName;
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
	
}
