package com.yash.foodie.exception;

public class ItemIdException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public ItemIdException(String msg) {
		super(msg);
	}
}