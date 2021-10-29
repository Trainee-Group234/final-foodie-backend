package com.yash.foodie.exception;

public class CategoryNameException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public CategoryNameException(String msg) {
		super(msg);
	}
}
