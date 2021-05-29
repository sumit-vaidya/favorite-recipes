package com.project.favorite.recipes.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Recipes {

	@Id
	private Integer recipesId;
	
	@Column(length = 25)
	private String recipesName;
	
	private String recipesType;
	
	private LocalDate createdAt;
	
	private LocalDate updatedAt;	
	
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

	public Integer getRecipesId() {
		return recipesId;
	}

	public void setRecipesId(Integer recipesId) {
		this.recipesId = recipesId;
	}

	public String getRecipesName() {
		return recipesName;
	}

	public void setRecipesName(String recipesName) {
		this.recipesName = recipesName;
	}

	public String getRecipesType() {
		return recipesType;
	}

	public void setRecipesType(String recipesType) {
		this.recipesType = recipesType;
	}

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="RECIPES_INGREDIENTS_MAPPING", joinColumns=@JoinColumn(name="RECIPES_ID_FK"),inverseJoinColumns=@JoinColumn(name="INGREDIENTS_ID_FK"))
	private List<Ingredients> ingredients = new ArrayList<>();

		public List<Ingredients> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Recipes [recipesId=" + recipesId + ", recipesName=" + recipesName + ", recipesType=" + recipesType
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", ingredients=" + ingredients + "]";
	}
	
}
