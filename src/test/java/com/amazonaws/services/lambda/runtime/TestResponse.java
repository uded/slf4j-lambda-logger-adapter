package com.amazonaws.services.lambda.runtime;

/**
 * Created by jeremyw on 8/2/15.
 */
public class TestResponse {

	private final String message;

	public TestResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
