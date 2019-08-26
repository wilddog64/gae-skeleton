package com.bigfishgames.gaeskeleton.sample;

import com.bigfishgames.gaeskeleton.memcache.MemcacheClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SampleService {
	private MemcacheClient memcacheClient;

	@Autowired
	public SampleService(MemcacheClient memcacheClient) {
		this.memcacheClient = memcacheClient;
	}

	public void setValue(String key, String value) {
		this.memcacheClient.put(key, value);
	}

	public String getValue(String key) {
		return (String)this.memcacheClient.get(key);
	}
}
