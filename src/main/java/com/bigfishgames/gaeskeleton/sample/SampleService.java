package com.bigfishgames.gaeskeleton.sample;

import com.bigfishgames.gaeskeleton.exception.ApiException;
import com.bigfishgames.gaeskeleton.memcache.MemcacheClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SampleService {
	private SampleRepository sampleRepository;
	private MemcacheClient memcacheClient;

	@Autowired
	public SampleService(SampleRepository sampleRepository, MemcacheClient memcacheClient) {
		this.sampleRepository = sampleRepository;
		this.memcacheClient = memcacheClient;
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

	public void setValue(String key, String value) {
		this.memcacheClient.put(key, value);
	}

	public String getValue(String key) {
		return (String)this.memcacheClient.get(key);
	}
}
