package com.bigfishgames.gaeskeleton.sample;

import com.bigfishgames.gaeskeleton.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SampleService {
	private SampleRepository sampleRepository;

	@Autowired
	public SampleService(SampleRepository sampleRepository) {
		this.sampleRepository = sampleRepository;
	}

	public void testGetList() {
		System.out.println("testGetList");

		try {
			String retJson = sampleRepository.getAddresses(5);
			System.out.println(retJson);
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}
}
