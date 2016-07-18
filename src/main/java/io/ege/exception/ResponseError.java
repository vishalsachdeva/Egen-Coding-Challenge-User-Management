package io.ege.exception;

import spark.Response;

public class ResponseError {
	private String message;

	public ResponseError(String message, Response response) {
		this.message = String.format(message, response);
	}

	public ResponseError(Exception e) {
		this.message = e.getMessage();
	}

	public String getMessage() {
		return this.message;
	}
	public String toString()
	{
		return message;
		
	}
}
