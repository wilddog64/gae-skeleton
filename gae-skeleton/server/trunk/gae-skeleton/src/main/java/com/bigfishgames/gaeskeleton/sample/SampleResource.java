package com.bigfishgames.gaeskeleton.sample;

import com.bigfishgames.gaeskeleton.sample.messages.SamplePostRequest;
import com.bigfishgames.gaeskeleton.sample.messages.SamplePostResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/sample")
public class SampleResource {
	public SampleResource() {

	}

	@GetMapping("/get/{id}")
	public String sampleGet(@PathVariable Long id) {
		return "sampleGet: " + id;
	}

	@GetMapping("/getList")
	public void testGetList() {
		SampleService service = new SampleService();
		service.testGetList();
	}

	@PostMapping("/post")
	public SamplePostResponse samplePost(@RequestBody SamplePostRequest request) {
		return new SamplePostResponse(request.getRequestInt(), request.getRequestString(), request.getRequestFloat());
	}
}
