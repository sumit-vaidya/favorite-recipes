package com.project.favorite.recipes.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.favorite.recipes.Exceptions.FavoriteRecipesException;
import com.project.favorite.recipes.entity.Recipes;
import com.project.favorite.recipes.entity.SelectedIngredients;
import com.project.favorite.recipes.model.RecipesDTO;
import com.project.favorite.recipes.model.SelectedIngredientsDTO;
import com.project.favorite.recipes.repository.RecipesRepository;
import com.project.favorite.recipes.service.IRecipesService;
import com.project.favorite.recipes.util.FavoriteRecipesErrorCode;
import com.project.favorite.recipes.util.FavoriteRecipesResponse;

/**
 * {@link RecipesServiceImpl}
 * 
 * Recipe service impl is used to write business logic for recipes
 * 
 * @author Sumit.Vaidya
 *
 */
@Service
public class RecipesServiceImpl implements IRecipesService {

	private static final Logger logger = LogManager.getLogger(RecipesServiceImpl.class);

	@Autowired
	private RecipesRepository recipesRepository;

	@Override
	public List<RecipesDTO> searchAllRecipes() {
		logger.info("FR-INFO Method  RecipesServiceImpl.searchAllRecipes");
		List<Recipes> recipesList = recipesRepository.findAll();

		List<RecipesDTO> recipesDTOList = new ArrayList<>();
		// Recipes DTO object formation to show it on the UI
		recipesList.forEach(recipe -> {
			RecipesDTO recipesDTO = new RecipesDTO();
			recipesDTO.setRecipesId(recipe.getRecipesId());
			recipesDTO.setRecipesName(recipe.getRecipesName());
			recipesDTO.setRecipesType(recipe.getRecipesType());
			recipesDTO.setNoOfPerson(recipe.getNoOfPerson());
			recipesDTO.setCookingInstruction(recipe.getCookingInstruction());
			recipesDTO.setUpdatedAt(recipe.getUpdatedAt());
			extractedSelectedIngredients(recipe, recipesDTO);
			recipesDTOList.add(recipesDTO);
		});
		return recipesDTOList;
	}

	@Override
	public String addRecipe(RecipesDTO recipesDTO) {
		logger.info("FR-INFO Method  RecipesServiceImpl.addRecipe");
		// Formation of recipe object to store in the recipe table of database
		Recipes recipes = new Recipes();
		recipes.setRecipesId(recipesDTO.getRecipesId());
		recipes.setRecipesName(recipesDTO.getRecipesName());
		recipes.setRecipesType(recipesDTO.getRecipesType());
		recipes.setNoOfPerson(recipesDTO.getNoOfPerson());
		recipes.setCookingInstruction(recipesDTO.getCookingInstruction());
		recipes.setCreatedAt(LocalDateTime.now());
		recipes.setUpdatedAt(LocalDateTime.now());
		List<SelectedIngredients> selectedIngredientsList = formedSelectedIngredientsForDB(recipesDTO);
		recipes.setSelectedIngredients(selectedIngredientsList);
		
		Recipes searchedRecipes = recipesRepository.findByRecipesName(recipes.getRecipesName());
		if (searchedRecipes != null && searchedRecipes.getRecipesId() != 0) {
			return "Recipe already exists";
		} else {
			recipesRepository.save(recipes);
			return "Recipe is added to database";
		}
	}

	private List<SelectedIngredients> formedSelectedIngredientsForDB(RecipesDTO recipesDTO) {
		List<SelectedIngredientsDTO> list = recipesDTO.getSelectedIngredientsList();
		List<SelectedIngredients> selectedIngredientsList = new ArrayList<>();
		list.forEach(dto ->{
			SelectedIngredients selectedIngredients = new SelectedIngredients();
			selectedIngredients.setSelectedIngredientId(dto.getSelectedIngredientId());
			selectedIngredients.setSelectedIngredientsName(dto.getSelectedIngredientsName());
			selectedIngredientsList.add(selectedIngredients);
		});
		return selectedIngredientsList;
	}

	@Override
	public RecipesDTO searchRecipeByRecipeName(String recipeName) throws FavoriteRecipesException {
		logger.info("FR-INFO Method  RecipesServiceImpl.searchRecipeByRecipeName : " + recipeName);
		RecipesDTO recipesDTO = new RecipesDTO();
		try {
			Recipes searchedRecipes = recipesRepository.findByRecipesName(recipeName);

			// if search criteria is not matched then throwing user defined exception
			if (searchedRecipes == null) {
				FavoriteRecipesException asException = new FavoriteRecipesException();
				FavoriteRecipesResponse errorResponse = new FavoriteRecipesResponse();
				logger.error(
						"LYT-ERROR Method RecipesServiceImpl.searchRecipeByRecipeName : Search criteria doesn't meet... ");
				errorResponse.setErrorMsg("Search criteria doesn't meet...");
				errorResponse.setErrorCode(FavoriteRecipesErrorCode.ERR_SEARCH_NOT_FOUND);
				asException.setErrResponse(errorResponse);
				throw asException;
			}

			BeanUtils.copyProperties(searchedRecipes, recipesDTO);

			extractedSelectedIngredients(searchedRecipes, recipesDTO);

		} catch (FavoriteRecipesException e) {
			throw e;
		} catch (Exception e) {
			FavoriteRecipesException asException = new FavoriteRecipesException();
			FavoriteRecipesResponse errorResponse = new FavoriteRecipesResponse();
			logger.error(
					"LYT-ERROR Method RecipesServiceImpl.searchRecipeByRecipeName " + e, e);
			errorResponse.setErrorMsg("Something went wrong while searching");
			errorResponse.setErrorCode(FavoriteRecipesErrorCode.ERR_SEARCH_PROCESSING);
			asException.setErrResponse(errorResponse);			
			throw asException;
		}
		return recipesDTO;
	}

	private void extractedSelectedIngredients(Recipes searchedRecipes, RecipesDTO recipesDTO) {
		List<SelectedIngredientsDTO> list = new ArrayList<SelectedIngredientsDTO>();
		if(!searchedRecipes.getSelectedIngredients().isEmpty()) {
			searchedRecipes.getSelectedIngredients().forEach(selected ->{
				SelectedIngredientsDTO selectedDto = new SelectedIngredientsDTO();
				selectedDto.setSelectedIngredientId(selected.getSelectedIngredientId());
				selectedDto.setSelectedIngredientsName(selected.getSelectedIngredientsName());
				list.add(selectedDto);
			});
		}
		recipesDTO.setSelectedIngredientsList(list);
	}

	@Override
	public String deleteRecipe(Integer id) {
		logger.info("FR-INFO Method  RecipesServiceImpl.deleteRecipe : " + id);
		String message = "Recipe doesn't exist";
		if (recipesRepository.existsById(id)) {
			recipesRepository.deleteById(id);
			message = "Recipe is deleted from database";
		}
		return message;
	}

	@Override
	public RecipesDTO updateRecipe(RecipesDTO recipesDTO) {
		logger.info("FR-INFO Method  RecipesServiceImpl.updateRecipe");
		Recipes recipes = new Recipes();
		BeanUtils.copyProperties(recipesDTO, recipes);
		if (recipesRepository.existsById(recipes.getRecipesId())) {
			List<SelectedIngredients> selectedIngredientsList = formedSelectedIngredientsForDB(recipesDTO);
			recipes.setSelectedIngredients(selectedIngredientsList);
			recipes.setUpdatedAt(LocalDateTime.now());
			recipesRepository.saveAndFlush(recipes);
			return recipesDTO;
		}
		return null;
	}

}
