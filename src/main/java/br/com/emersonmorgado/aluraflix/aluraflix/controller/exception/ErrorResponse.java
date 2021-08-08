package br.com.emersonmorgado.aluraflix.aluraflix.controller.exception;

import java.util.List;

public class ErrorResponse {
	
	 private final String message;
	 private final List<ErrorObject> errors;
	 
	public ErrorResponse(String message,List<ErrorObject> errors) {
		this.message = message;
		this.errors = errors;
	}

	public ErrorResponse(String message) {
		this.message = message;
		this.errors = null;
	}

	public String getMessage() {
		return message;
	}

	public List<ErrorObject> getErrors() {
		return errors;
	}
	 
}
