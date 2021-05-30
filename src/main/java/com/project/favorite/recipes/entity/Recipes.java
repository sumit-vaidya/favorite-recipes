package com.project.favorite.recipes.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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

	private String cookingInstruction;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name="RECIPESID_FK")
	private List<SelectedIngredients> selectedIngredients = new ArrayList<>();

	public String getCookingInstruction() {
		return cookingInstruction;
	}

	public void setCookingInstruction(String cookingInstruction) {
		this.cookingInstruction = cookingInstruction;
	}

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

	public List<SelectedIngredients> getSelectedIngredients() {
		return selectedIngredients;
	}

	public void setSelectedIngredients(List<SelectedIngredients> selectedIngredients) {
		this.selectedIngredients = selectedIngredients;
	}
}
