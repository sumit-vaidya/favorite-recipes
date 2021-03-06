package com.project.favorite.recipes.model;

import java.io.Serializable;


/**
 * 
 * {@link IngredientsDTO}
 * 
 * IngredientsDTO class has been created for front-end to connect with back-end entity
 * 
 * @author Sumit.Vaidya
 *
 */
public class IngredientsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5590952445541243326L;
	private Integer ingredientId;
	
	private String ingredientsName;

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
	

}
