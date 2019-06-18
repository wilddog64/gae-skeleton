package com.bigfishgames.gaeskeleton.sample.messages;

public class SamplePostRequest {
	private int requestInt;
	private String requestString;
	private float requestFloat;

	public SamplePostRequest() {

	}

	public SamplePostRequest(int requestInt, String requestString, float requestFloat) {
		this.requestInt = requestInt;
		this.requestString = requestString;
		this.requestFloat = requestFloat;
	}

	public int getRequestInt() {
		return requestInt;
	}

	public void setRequestInt(int requestInt) {
		this.requestInt = requestInt;
	}

	public String getRequestString() {
		return requestString;
	}

	public void setRequestString(String requestString) {
		this.requestString = requestString;
	}

	public float getRequestFloat() {
		return requestFloat;
	}

	public void setRequestFloat(float requestFloat) {
		this.requestFloat = requestFloat;
	}
}
