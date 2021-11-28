package com.innohotsource.hotjson.Json;

import com.innohotsource.hotjson.Json.sample.Sample;
import com.innohotsource.hotjson.Json.sample.Sample1;
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


        Sample1 sample1 = (Sample1) JsonToObject.fromJson(sample, new Sample1());
        System.out.println("sample1.tostring = " + sample1.toString());

        Assertions.assertEquals(sample1.getName(), "sampleName");
        
        
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "sampleName");
        jsonObject.put("id", 1L);
        JSONObject jsonObejct1 = new JSONObject();
        jsonObejct1.put("subName", "subName");
        jsonObejct1.put("subId", 1L);
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("subSubName", "subSubName");
        jsonObject2.put("subSubId", 1L);
        jsonObejct1.put("sub", jsonObject2);
        jsonObject.put("subSample", jsonObejct1);
        System.out.println("jsonObject.toJSONString() = " + jsonObject.toJSONString());
        Sample sample2 = (Sample) JsonToObject.fromJson(jsonObject, new Sample());
        System.out.println("sample2 = " + sample2.toString());
    }
}
