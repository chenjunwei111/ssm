package com.spdb.exception;

public class TransactionalException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TransactionalException() {
		super();
	}

	public TransactionalException(String message) {
		super(message);
	}

}