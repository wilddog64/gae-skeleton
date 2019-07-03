package com.bigfishgames.gaeskeleton.login.messages;

public class LoginRequest {
	private String raveID;
	private String raveAccessToken;

	public LoginRequest() {

	}

	public LoginRequest(String raveID, String raveAccessToken) {
		this.raveID = raveID;
		this.raveAccessToken = raveAccessToken;
	}

	public String getRaveID() {
		return raveID;
	}

	public void setRaveID(String raveID) {
		this.raveID = raveID;
	}

	public String getRaveAccessToken() {
		return raveAccessToken;
	}

	public void setRaveAccessToken(String raveAccessToken) {
		this.raveAccessToken = raveAccessToken;
	}
}
