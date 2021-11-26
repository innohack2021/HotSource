package com.innohotsource.hotjson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Hello {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("test.json"));
            JSONObject jsonObject = (JSONObject) obj;

            Map<String, Object> map = new HashMap<String, Object>();
            JSONObject jsonObj = (JSONObject) jsonObject.get("properties");
            Iterator<String> keysItr = jsonObj.keySet().iterator();
            while(keysItr.hasNext()) {
                String key = keysItr.next();
                Object value = jsonObj.get(key);
                System.out.println(key + " : " + value);
                if (value instanceof JSONArray) {

                }
                else if (value instanceof JSONObject) {

                }
                map.put(key, value);
                System.out.println("test: " + map.get(key));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
