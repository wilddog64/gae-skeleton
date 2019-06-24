package com.bigfishgames.gaeskeleton.sample;

import org.json.JSONObject;
import org.json.JSONArray;
import com.bitheads.braincloud.s2s.Brainclouds2s;


public class SampleService {
	private static Brainclouds2s _s2sClient;
	static protected String m_serverUrl = "https://sharedprod.braincloudservers.com/s2sdispatcher";
	static protected String m_appId = "12601";
	static protected String m_serverSecret = "e948eb16-8023-437e-be2e-432d2c3b6adb";
	static protected String m_serverName = "GAESkeleton";

	public SampleService() {
		_s2sClient = new Brainclouds2s();
		_s2sClient.init(m_appId, m_serverName, m_serverSecret);
		_s2sClient.setLogEnabled(true);

		if (!_s2sClient.isIsInitialized()) {
			fail("Initialization Failed");
		}
	}

	public void testGetList() {
		System.out.println("testGetList");
		JSONObject json = new JSONObject();
		json.put("service", "globalEntity");
		json.put("operation", "GET_LIST");

		JSONObject orderBy = new JSONObject();
		JSONObject where = new JSONObject();
		JSONObject params = new JSONObject();
		where.put("entityType", "address");
		params.put("where", where);
		params.put("orderBy", orderBy);
		params.put("maxReturn", 5);
		json.put("data", params);

		_s2sClient.request(json, (Brainclouds2s context, JSONObject jsonData) -> {
			if (context != _s2sClient) {
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
			JSONArray list = jsonData.getJSONObject("data").getJSONArray("entityList");

			String retJson = jsonData.toString();
			System.out.println(retJson);
			//return retJson;
		});
	}

	private void fail(String message) {
		System.out.println(message);
	}
}
