package com.innohotsource.hotjson.Json;

import org.json.simple.*;

import java.lang.reflect.Field;

public class ObjectToJson {

    public static JSONObject toJson(Object obj) throws IllegalAccessException {
        JSONObject jsonObject = new JSONObject();
        return toJson(obj, jsonObject);
    }

    private static JSONObject toJson(Object obj, JSONObject map) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String key = field.getName();

            Object value = field.get(obj);

            if(value instanceof String){
                map.put(key, value.toString());
                continue;
            }

            if(value instanceof Double){
                if(((Double)value).isInfinite() || ((Double)value).isNaN())
                    map.put(key, "null");
                else
                    map.put(key, value);
                continue;
            }

            if(value instanceof Float){
                if(((Float)value).isInfinite() || ((Float)value).isNaN())
                    map.put(key, "null");
                else
                    map.put(key, value);
                continue;
            }

            if(value instanceof Number){
                map.put(key, value);
                continue;
            }

            if(value instanceof Boolean){
                map.put(key, value);
                continue;
            }



            if(value instanceof Object){
                JSONObject newMap = toJson(value);
                map.put(key, newMap);
            }

        }

        return map;
    }

}
