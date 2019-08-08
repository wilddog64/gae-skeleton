package com.bigfishgames.gaeskeleton.login;

import com.bigfishgames.gaeskeleton.login.messages.LoginRequest;
import com.bigfishgames.gaeskeleton.login.messages.LoginResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/login")
public class LoginResource {
	public LoginResource() {

	}

	@PostMapping("/")
	public LoginResponse login(@RequestBody LoginRequest request) {
		return new LoginResponse();
	}
}
