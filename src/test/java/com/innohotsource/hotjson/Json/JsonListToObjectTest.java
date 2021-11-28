package com.innohotsource.hotjson.Json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class JsonListToObjectTest {
    
    @Test
    void ListToObject(){
        JSONObject sample = new JSONObject();
        sample.put("name", "sampleName");
        sample.put("id", 1L);

        JSONObject subSample = new JSONObject();
        subSample.put("subName", "sub1");
        subSample.put("subId", 1L);

        JSONObject subSample1 = new JSONObject();
        subSample.put("subName", "sub2");
        subSample.put("subId", 2L);

        JSONObject Sub = new JSONObject();
        Sub.put("subSubName", "subsub");
        Sub.put("subSubId", 1L);

        JSONObject Sub1 = new JSONObject();
        Sub1.put("subSubName", "subsub");
        Sub1.put("subSubId", 2L);

        JSONArray subList = new JSONArray();
        subList.add(Sub);
        subList.add(Sub1);

        subSample.put("subList",subList);

        JSONArray subSampleList = new JSONArray();
        subSampleList.add(subSample);

        sample.put("subSampleList", subSampleList);
        System.out.println("sample = " + sample.toJSONString());

        JsonToObject json = new JsonToObject();
        Sample1 sample1 = (Sample1) json.fromJson(sample, new Sample1());
        System.out.println("sample1.tostring = " + sample1.toString());

        Assertions.assertEquals(sample1.getName(), "sampleName");
    }
}
