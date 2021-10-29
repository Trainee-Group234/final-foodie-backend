package com.yash.foodie.exception;

public class AccountNotActivatedExcetion extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public AccountNotActivatedExcetion(String msg) {
		super(msg);
	}

}
