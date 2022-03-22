package com.spring.crud.exception;

@SuppressWarnings("serial")
public class AgencyNotFoundException extends RuntimeException {

	public AgencyNotFoundException(String message) {
		super(message);
	}

}
