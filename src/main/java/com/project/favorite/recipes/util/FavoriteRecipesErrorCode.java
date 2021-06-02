package com.project.favorite.recipes.util;

/**
 * {@link FavoriteRecipesErrorCode}
 * 
 * Error code has been added for exception notification.
 * 
 * @author Sumit.Vaidya
 *
 */
public enum FavoriteRecipesErrorCode {	 	
	    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR"),
	    RECIPE_PROCESSING_ERROR("RECIPE_PROCESSING_ERROR"),
	    USER_PROCESSING_ERROR("USER_PROCESSING_ERROR"),
	    ERR_SEARCH_NOT_FOUND("ERR_SEARCH_NOT_FOUND"),
	    ERR_SEARCH_PROCESSING("ERR_SEARCH_PROCESSING");

	    private final String name;

	    private FavoriteRecipesErrorCode(String s) {
	        name = s;
	    }

	    public boolean equalsName(String otherName) {
	        return name.equalsIgnoreCase(otherName);
	    }

	    @Override
	    public String toString() {
	        return this.name;
	    }
}
