package com.spring.crud.exception;

@SuppressWarnings("serial")
public class ClientNotFoundException extends RuntimeException {

	public ClientNotFoundException(String message) {
		super(message);
	}

}
