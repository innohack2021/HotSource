package com.innohotsource.hotjson.Json;

import org.json.simple.*;

import java.lang.reflect.Field;
import java.util.*;

/**
 * <p>
 * auto convert object to json
 * </p>
 *
 * @author cho wonwoo
 * @version 1.1
 */
public class ObjectToJson {


    /**
     * Create a JsonObject and bind data from the given object as parameter.
     * @param obj Object to get data.
     * @return jsonObject converted from given object.
     * @throws IllegalAccessException argument is a instance of String or primitive value
     **/
    public static JSONObject toJson(Object obj) throws IllegalAccessException {

        if (isEndValue(obj)) {
            throw new IllegalArgumentException("argument is a instance of String or primitive value");
        } else if (obj instanceof Collection) {
            throw new IllegalArgumentException("argument is not a single reference variable");
        }

        JSONObject jsonObject = new JSONObject();
        return objectToJson(obj, jsonObject);

    }

    /**
     * Create String and write data from the given object as parameter.
     * @param obj Object to get data.
     * @return JSON formatted String converted from given object
     * @throws IllegalAccessException
     */
    public static String toJsonString(Object obj) throws IllegalAccessException {
        return toJson(obj).toJSONString();
    }

    private static JSONObject objectToJson(Object obj, JSONObject map) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {

            field.setAccessible(true);
            String key = field.getName();
            Object value = field.get(obj);

            if (isEndValue(value)) {
                map.put(key, value);
                continue;
            }

            if (value.getClass().isArray()) {
                JSONArray newList = new JSONArray();
                map.put(key, arrayToJson((Object[]) value, newList));
                continue;
            }

            if (value instanceof List) {
                JSONArray newList = new JSONArray();
                map.put(key, listToJson((List) value, newList));
                continue;
            }

            if (value instanceof Map) {
                JSONObject newMap = new JSONObject();
                map.put(key, mapToJson((Map) value, newMap));
                continue;
            }

            JSONObject newObject = new JSONObject();
            JSONObject newMap = objectToJson(value, newObject);
            map.put(key, newMap);
        }

        return map;
    }

    private static JSONArray arrayToJson(Object[] arr, JSONArray lst) throws IllegalAccessException {
        for (Object value : arr) {

            if (isEndValue(value)) {
                lst.add(value);
                continue;
            }

            if (value.getClass().isArray()) {
                JSONArray newList = new JSONArray();
                lst.add(arrayToJson((Object[]) value, newList));
                continue;
            }

            if (value instanceof List) {
                JSONArray newList = new JSONArray();
                lst.add(listToJson((List) value, newList));
                continue;
            }

            if (value instanceof Map) {
                JSONObject newMap = new JSONObject();
                lst.add(mapToJson((Map) value, newMap));
                continue;
            }

            JSONObject newObject = new JSONObject();
            JSONObject newMap = objectToJson(value, newObject);
            lst.add(newMap);

        }
        return lst;
    }

    private static JSONArray listToJson(List src, JSONArray lst) throws IllegalAccessException {
        for (Object value : src) {

            if (isEndValue(value)) {
                lst.add(value);
                continue;
            }

            if (value.getClass().isArray()) {
                JSONArray newList = new JSONArray();
                lst.add(arrayToJson((Object[]) value, newList));
                continue;
            }

            if (value instanceof List) {
                JSONArray newList = new JSONArray();
                lst.add(listToJson((List) value, newList));
                continue;
            }

            if (value instanceof Map) {
                JSONObject newMap = new JSONObject();
                lst.add(mapToJson((Map) value, newMap));
                continue;
            }

            JSONObject newObject = new JSONObject();
            JSONObject newMap = objectToJson(value, newObject);
            lst.add(newMap);

        }
        return lst;
    }

    private static Object mapToJson(Map src, JSONObject map) throws IllegalAccessException {
        Iterator iterator = src.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            Object value = src.get(key);

            if (isEndValue(value)) {
                map.put(key, value);
                continue;
            }

            if (value.getClass().isArray()) {
                JSONArray newList = new JSONArray();
                map.put(key, arrayToJson((Object[]) value, newList));
                continue;
            }

            if (value instanceof List) {
                JSONArray newList = new JSONArray();
                map.put(key, listToJson((List) value, newList));
                continue;
            }

            if (value instanceof Map) {
                JSONObject newMap = new JSONObject();
                map.put(key, mapToJson((Map) value, newMap));
                continue;
            }

            JSONObject newObject = new JSONObject();
            JSONObject newMap = objectToJson(value, newObject);
            map.put(key, newMap);
        }
        return map;
    }

    private static boolean isEndValue(Object value) {

        if (value instanceof String) {
            return true;
        }

        if (value instanceof Double) {
            return true;
        }

        if (value instanceof Float) {
            return true;
        }

        if (value instanceof Number) {
            return true;
        }

        if (value instanceof Boolean) {
            return true;
        }

        return false;
    }

}