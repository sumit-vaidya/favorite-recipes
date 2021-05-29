package com.project.favorite.recipes.model;

import java.io.Serializable;

public class SelectedIngredientsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2815584116554620410L;
	
	private Integer selectedIngredientId;
	
	private String selectedIngredientsName;

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

}
