package com.innohotsource.hotjson.Json;

import com.innohotsource.hotjson.Json.sample.Sample;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

class JsonToObjectTest {

    @Test
    void fromJson() throws IllegalAccessException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "testName");
        jsonObject.put("id", 1L);

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("subName", "aaaa");
        jsonObject1.put("subId", 2L);


        JSONObject sub = new JSONObject();
        sub.put("subSubName", "sub");
        jsonObject1.put("sub",sub);
        jsonObject.put("subSample", jsonObject1);
        /**
         * {
         *   "testList":[{"listName":"testListName"}],
         *   "name":"testName",
         *   "Id":1
         *   }
         */
        System.out.println("jsonObject.toJSONString() = " + jsonObject.toJSONString());

        JsonToObject jsonToObject = new JsonToObject();
        Sample sample = (Sample) jsonToObject.fromJson(jsonObject, new Sample());
        System.out.println("sample = " + sample);


    }

}