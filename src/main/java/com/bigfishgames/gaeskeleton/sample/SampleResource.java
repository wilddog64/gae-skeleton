package com.bigfishgames.gaeskeleton.sample;

import com.bigfishgames.gaeskeleton.sample.messages.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/sample")
public class SampleResource {
	private SampleService sampleService;

	@Autowired
	public SampleResource(SampleService sampleService) {
		this.sampleService = sampleService;
	}

	@GetMapping("/get/{id}")
	public SampleGetResponse sampleGet(@PathVariable Long id) {
		SampleGetResponse response = new SampleGetResponse();
		response.setMessage("sampleGet: " + id);
		return response;
	}

	@GetMapping("/getList")
	public void testGetList() {
		sampleService.testGetList();
	}

	@PostMapping("/post")
	public SamplePostResponse samplePost(@RequestBody SamplePostRequest request) {
		return new SamplePostResponse(request.getRequestInt(), request.getRequestString(), request.getRequestFloat());
	}

	@GetMapping("/getmemcachevalue/{key}")
	public MemcacheGetResponse getMemcacheValue(@PathVariable String key) {
		MemcacheGetResponse response = new MemcacheGetResponse();
		response.key = key;
		response.value = this.sampleService.getValue(key);
		return response;
	}

	@PostMapping("/setmemcachevalue")
	public void setMemcacheValue(@RequestBody MemcacheSetRequest request) {
		this.sampleService.setValue(request.key, request.value);
	}
}
