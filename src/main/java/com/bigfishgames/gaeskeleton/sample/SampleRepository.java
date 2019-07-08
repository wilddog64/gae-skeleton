package com.bigfishgames.gaeskeleton.sample;

import com.bigfishgames.gaeskeleton.exception.ApiException;
import com.bitheads.braincloud.s2s.Brainclouds2s;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
public class SampleRepository {
	private Brainclouds2s brainclouds2s;

	@Autowired
	public SampleRepository(Brainclouds2s brainclouds2s) {
		this.brainclouds2s = brainclouds2s;
		if (!brainclouds2s.isIsInitialized()) {
			fail("Initialization Failed");
		}
	}

	public String getAddresses(int limit) throws ApiException {
		JSONObject json = new JSONObject();
		json.put("service", "globalEntity");
		json.put("operation", "GET_LIST");

		JSONObject orderBy = new JSONObject();
		JSONObject where = new JSONObject();
		JSONObject params = new JSONObject();
		where.put("entityType", "address");
		params.put("where", where);
		params.put("orderBy", orderBy);
		params.put("maxReturn", limit);
		json.put("data", params);

		CompletableFuture<String> jsonFuture
				= new CompletableFuture<>();

		brainclouds2s.request(json, (Brainclouds2s context, JSONObject jsonData) -> {
			if (context != brainclouds2s) {
				fail("wrong context returned");
			}
			if (jsonData.getInt("status") != 200) {
				fail("Error returned");
			}
			if (!jsonData.has("data")) {
				fail("Missing data in return");
			}
			if (!jsonData.getJSONObject("data").has("entityList")) {
				fail("Missing entityList in return");
			}

			jsonFuture.complete(jsonData.toString());
		});

		try {
			String retJson = jsonFuture.get();
			return retJson;
		} catch (InterruptedException iex) {
			throw new ApiException(iex);
		} catch (ExecutionException eex) {
			throw new ApiException(eex);
		}

	}

	private void fail(String message) {
		System.out.println(message);
	}
}
