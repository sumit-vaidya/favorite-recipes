package com.project.favorite.recipes.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * {@link RecipesDTO}
 * 
 * Recipes dto is created to store recipe details from UI and to UI
 * 
 * @author Sumit.Vaidya
 *
 */
public class RecipesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7045697167299630413L;
	
	private Integer recipesId;
	
	private String recipesName;
	
	private String recipesType;
	
	private Integer noOfPerson;
	
	private String cookingInstruction;
	
	private LocalDateTime updatedAt;
	
	private List<SelectedIngredientsDTO> selectedIngredientsList;
	
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

	public List<SelectedIngredientsDTO> getSelectedIngredientsList() {
		return selectedIngredientsList;
	}

	public void setSelectedIngredientsList(List<SelectedIngredientsDTO> selectedIngredientsList) {
		this.selectedIngredientsList = selectedIngredientsList;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}	
	
}
