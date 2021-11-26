package com.innohotsource.hotjson.Json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonToObjectTest {

    @Test
    void fromJson() throws IllegalAccessException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "testName");
        jsonObject.put("Id", 1L);

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("listName", "aaaa");

        jsonObject.put("testList", jsonObject1);

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