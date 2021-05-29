package com.project.favorite.recipes.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.project.favorite.recipes.converter.LocalDateTimeConverter;

@Entity
public class Recipes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "recipesId", updatable = false, nullable = false)
	private Integer recipesId;
	
	@Column(length = 30)
	private String recipesName;
	
	private String recipesType;
	
	private Integer noOfPerson;
	
	public Integer getNoOfPerson() {
		return noOfPerson;
	}

	public void setNoOfPerson(Integer noOfPerson) {
		this.noOfPerson = noOfPerson;
	}

	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime createdAt;
	
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime updatedAt;	
	
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
	@JoinTable(name="RECIPES_SELECTED_INGREDIENTS_MAPPING", joinColumns=@JoinColumn(name="RECIPES_ID_FK"),inverseJoinColumns=@JoinColumn(name="SELECTED_INGREDIENTS_ID_FK"))
	private List<SelectedIngredients> SelectedIngredients = new ArrayList<>();

	public List<SelectedIngredients> getSelectedIngredients() {
		return SelectedIngredients;
	}

	public void setSelectedIngredients(List<SelectedIngredients> selectedIngredients) {
		SelectedIngredients = selectedIngredients;
	}
}
