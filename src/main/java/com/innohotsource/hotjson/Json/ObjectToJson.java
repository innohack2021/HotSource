package com.innohotsource.hotjson.Json;

import org.json.simple.*;

import java.lang.reflect.Field;
import java.util.*;

public class ObjectToJson {

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
     * 전달받은 객체가 String 이 아니고 && 기본타입혹은 해당 기본 타입의 래퍼클래스가 아닌 경우
     * @param obj
     * @param map
     * @return
     * @throws IllegalAccessException
     */
    private static JSONObject objectToJson(Object obj, JSONObject map) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {

            field.setAccessible(true);
            String key = field.getName();

            Object value = field.get(obj);

            // String || primitive Wrapper 라면 바로 put
            if (isEndValue(value)) {
                map.put(key, value);
                continue;
            }

//            정상작동하지 않는 코드 -> array 를 걸러내는 방법을 강구해야 할 듯
//            if (value instanceof Arrays) {
//                JSONArray newList = new JSONArray();
//                System.out.println("array encountered");
//                map.put(key, arrayToJson((Arrays) value, newList));
//                continue;
//            }

            // List 를 구현한 객체인지 확인
            if (value instanceof List) {
                JSONArray newList = new JSONArray();
                map.put(key, listToJson((List) value, newList));
                continue;
            }

            // Map 을 구현한 객체인지 확인
            if (value instanceof Map) {
                JSONObject newMap = new JSONObject();
                map.put(key, mapToJson((Map) value, newMap));
                continue;
            }

            JSONObject newMap = toJson(value);
            map.put(key, newMap);
        }

        return map;
    }

    private static Object arrayToJson(Arrays value, JSONArray newList) {
        return null;
    }

    // 리스트 내부의 값이 String 이거나 primitive 가 아닌 경우 재귀로 반복해서 실행되도록 수정해야함
    private static JSONArray listToJson(List src, JSONArray newList) {
        for (Object content : src) {
            newList.add(content);
        }
        return newList;
    }

    // 맵 내부의 값이 String 이거나 primitive 가 아닌 경우 재귀로 반복해서 실행되도록 수정해야함
    private static Object mapToJson(Map src, JSONObject newMap) {
        Iterator iterator = src.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            Object value = src.get(key);
            newMap.put(key, value);
        }
        return newMap;
    }

    private static boolean isEndValue(Object value) {

        if(value instanceof String){
            return true;
        }

        if(value instanceof Double){
            return true;
        }

        if(value instanceof Float){
            return true;
        }

        if(value instanceof Number){
            return true;
        }

        if(value instanceof Boolean){
            return true;
        }

        return false;
    }

}