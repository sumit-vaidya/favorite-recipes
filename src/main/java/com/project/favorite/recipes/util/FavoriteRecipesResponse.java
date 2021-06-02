package com.project.favorite.recipes.util;

import org.springframework.http.HttpStatus;

public class FavoriteRecipesResponse {

	private HttpStatus status;
	private String errorMsg;
	private FavoriteRecipesErrorCode errorCode;
	private String referenceId;

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public FavoriteRecipesErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(FavoriteRecipesErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
}
