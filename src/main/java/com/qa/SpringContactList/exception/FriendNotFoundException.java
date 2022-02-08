package com.qa.SpringContactList.exception;

public class FriendNotFoundException extends RuntimeException{ //sigh2
	public FriendNotFoundException(String message) {
		super(message);
	}


}
