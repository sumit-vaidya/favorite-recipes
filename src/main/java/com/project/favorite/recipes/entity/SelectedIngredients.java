package com.project.favorite.recipes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * {@link SelectedIngredients}
 * Selected Ingredients entity class created to store selected ingredients from the UI to database table
 * @author Sumit.Vaidya
 *
 */
@Entity
public class SelectedIngredients {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	
	private Integer selectedIngredientId;
	
	@Column(length = 25)
	private String selectedIngredientsName;	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
