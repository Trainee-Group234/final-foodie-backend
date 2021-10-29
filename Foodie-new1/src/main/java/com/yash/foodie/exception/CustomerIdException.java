package com.yash.foodie.exception;

public class CustomerIdException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public CustomerIdException(String msg) {
		super(msg);
	}
}
