package com.project.favorite.recipes.entity;

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
	
	@Column(length = 15)
	private String recipesName;
	
	private String recipesType;
	
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

		public List<Ingredients> getAuthors() {
		return ingredients;
	}

	public void setAuthors(List<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}
	
}
