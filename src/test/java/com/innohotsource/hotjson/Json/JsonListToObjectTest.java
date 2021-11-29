package com.innohotsource.hotjson.Json;

import com.innohotsource.hotjson.Json.sample.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class JsonListToObjectTest {

    @Test
    void ListToObject() throws IllegalAccessException, ParseException {
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
        /**
         * sample = {
         * "subSampleList":[{"subId":2,
         *                  "subList":[{"subSubName":"subsub","subSubId":1},{"subSubName":"subsub","subSubId":2}],
         *                  "subName":"sub2"}],
         * "name":"sampleName",
         * "id":1}
         */

        Sample1 sample1 =  JsonToObject.fromJson(sample, Sample1.class);
        String sampleString = sample.toJSONString();
        Sample1 sample11 = JsonToObject.fromJsonString(sampleString, Sample1.class);
        System.out.println("sample1.getSubSampleList().get(0).getSubName() = " + sample1.getSubSampleList().get(0).getSubName());

        Assertions.assertEquals(sample1.getName(), "sampleName");
        Assertions.assertEquals(sample1.getId(), 1L);
        System.out.println("sample1.getSubSampleList().get(0).getSubList().get(1) = " + sample1.getSubSampleList().get(0).getSubList().get(1));
//





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




        String name = (String) jsonObject.get("name");
        Long id = (Long) jsonObject.get("id");
        String subName = (String) ((JSONObject) jsonObject.get("subSample")).get("subName");
        Long subId = (Long) ((JSONObject) jsonObject.get("subSample")).get("subId");
        String subSubName = (String) ((JSONObject)((JSONObject)jsonObject.get("subSample")).get("sub")).get("subSubName");
        Long subSubId = (Long) ((JSONObject)((JSONObject)jsonObject.get("subSample")).get("sub")).get("subSubId");
        Sub sub = new Sub();
        sub.setSubSubId(subSubId);
        sub.setSubSubName(subSubName);
        SubSample subSample2 = new SubSample();
        subSample2.setSub(sub);
        subSample2.setSubId(subId);
        subSample2.setSubName(subName);
        
        Sample returnSample = new Sample();
        returnSample.setSubSample(subSample2);
        returnSample.setId(id);
        returnSample.setName(name);
        System.out.println("returnSample = " + returnSample);

        Sample sample2 = JsonToObject.fromJson(jsonObject, Sample.class);
    }
}
