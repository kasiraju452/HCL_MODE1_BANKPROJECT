package com.bankapp.model.dao.exceptions;

public class AccountNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6471871115302369565L;

	public AccountNotFoundException(String message) {
		super(message);
	}

}
