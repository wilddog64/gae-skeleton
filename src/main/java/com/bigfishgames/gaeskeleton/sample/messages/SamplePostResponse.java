package com.bigfishgames.gaeskeleton.sample.messages;

public class SamplePostResponse {
	private int responseInt;
	private String responseString;
	private float responstFloat;

	public SamplePostResponse() {

	}

	public SamplePostResponse(int responseInt, String responseString, float responstFloat) {
		this.responseInt = responseInt;
		this.responseString = responseString;
		this.responstFloat = responstFloat;
	}

	public int getResponseInt() {
		return responseInt;
	}

	public void setResponseInt(int responseInt) {
		this.responseInt = responseInt;
	}

	public String getResponseString() {
		return responseString;
	}

	public void setResponseString(String responseString) {
		this.responseString = responseString;
	}

	public float getResponstFloat() {
		return responstFloat;
	}

	public void setResponstFloat(float responstFloat) {
		this.responstFloat = responstFloat;
	}
}
