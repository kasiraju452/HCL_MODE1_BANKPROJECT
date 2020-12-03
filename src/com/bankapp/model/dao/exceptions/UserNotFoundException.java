package com.bankapp.model.dao.exceptions;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6471871115302369565L;

	public UserNotFoundException(String message) {
		super(message);
	}

}
