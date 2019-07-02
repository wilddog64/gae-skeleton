package com.bigfishgames.gaeskeleton.sample.messages;

public class SampleGetResponse {
	private String message;

	public SampleGetResponse() {

	}

	public SampleGetResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
