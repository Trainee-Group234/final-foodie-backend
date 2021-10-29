package com.yash.foodie.exception;

public class ItemNameException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public ItemNameException(String msg) {
		super(msg);
	}
}