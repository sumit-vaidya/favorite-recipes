package com.project.favorite.recipes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ingredients {
	@Id
	private Integer ingredientId;
	
	@Column(length = 15)
	private String ingredientsName;
	
	
	@Override
	public String toString() {
		return "Ingredients [ingredientId=" + ingredientId + ", ingredientsName=" + ingredientsName + "]";
	}	
	
}
