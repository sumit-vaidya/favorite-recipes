package com.project.favorite.recipes.Exceptions;

import com.project.favorite.recipes.util.FavoriteRecipesResponse;

/**
 * {@link FavoriteRecipesException}
 * 
 * Exception class is created for notifying users
 * 
 * @author Sumit.Vaidya
 *
 */
public class FavoriteRecipesException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 853596593825423755L;
	private FavoriteRecipesResponse errResponse;

    public FavoriteRecipesResponse getErrResponse() {
        return errResponse;
    }

    public void setErrResponse(FavoriteRecipesResponse errResponse) {
        this.errResponse = errResponse;
    }
}
