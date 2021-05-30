package com.project.favorite.recipes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

	private List<SelectedIngredientsDTO> selectedIngredientsList = new ArrayList<SelectedIngredientsDTO>();

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
}
