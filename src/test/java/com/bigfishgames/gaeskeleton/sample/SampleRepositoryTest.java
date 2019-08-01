package com.bigfishgames.gaeskeleton.sample;

import com.bigfishgames.gaeskeleton.exception.ApiException;
import com.bitheads.braincloud.s2s.Brainclouds2s;
import com.bitheads.braincloud.s2s.IS2SCallback;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleRepositoryTest {
    @Autowired
    private SampleRepository sampleRepository;

    @MockBean
    private Brainclouds2s mockBrainclouds2s;

    @Test
    public void getAddressesSuccess() throws ApiException  {
        JSONObject storedJson = buildStoredAddressJSON();
        doAnswer(buildAnswerForBraincloudRequest(storedJson))
                .when(mockBrainclouds2s).request(any(JSONObject.class), any(IS2SCallback.class));

        JSONObject result = sampleRepository.getAddresses(1);
        assertEquals(storedJson, result);
    }
    private JSONObject buildStoredAddressJSON() {
        JSONObject storedJson = new JSONObject();
        JSONObject data = new JSONObject();
        JSONObject addressEntity = new JSONObject();
        addressEntity.put("gameId", "12601");
        addressEntity.put("entityIndexedId", (String)null);
        addressEntity.put("timeToLive", -1);
        addressEntity.put("createdAt", 1561076885205L);
        JSONObject addressData = new JSONObject();
        addressData.put("street", "1309 Carling");
        addressEntity.put("data", addressData);
        addressEntity.put("entityType", "address");
        addressEntity.put("entityId", "f87fdbc8-3fb6-4ccf-b7bd-f1fd73cf66e4");
        JSONObject addressAcl = new JSONObject();
        addressAcl.put("other", 1);
        addressEntity.put("acl", addressAcl);
        addressEntity.put("ownerId","d1e817ee-2f3a-4d8c-941c-58369b4e1a7d");
        addressEntity.put("expiresAt",9223372036854775807L);
        addressEntity.put("updatedAt",1561076885205L);
        data.put("entityList", new JSONObject[]{ addressEntity });
        data.put("entityListCount", 1);
        storedJson.put("data", data);
        storedJson.put("status", 200);
        return storedJson;
    }

    private Answer buildAnswerForBraincloudRequest(JSONObject jsonObjectToReturn) {
        return invocation -> {
            IS2SCallback callback = invocation.getArgument(1);
            callback.s2sCallback(mockBrainclouds2s, jsonObjectToReturn);
            return null;
        };
    }

}
