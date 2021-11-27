package com.innohotsource.hotjson.Json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;


public class JsonToObject {

    public static Object fromJson(JSONObject json,Object instance){

        Field[] fields = instance.getClass().getDeclaredFields();
        Arrays.stream(fields).forEach(
                field -> {
                    field.setAccessible(true);
                    try {
                        fieldSet(field, json, instance);
                    } catch (IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
        );
        return instance;
    }

    private static void fieldSet(Field field, JSONObject json, Object instance) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        if (json.get(field.getName()) instanceof String) {
            field.set(instance, json.get(field.getName()));
        } else if (json.get(field.getName()) instanceof Long) {
            field.set(instance, json.get(field.getName()));
        } else if (json.get(field.getName()) instanceof Integer) {
            field.set(instance, json.get(field.getName()));
        } else if (json.get(field.getName()) instanceof Float) {
            field.set(instance, json.get(field.getName()));
        } else if (json.get(field.getName()) instanceof Number) {
            field.set(instance, json.get(field.getName()));
        } else if (field.getType() == List.class) {
            JSONArray jsonArray = (JSONArray) json.get(field.getName());
            field.set(instance,jsonArray);
            }
        else if (json.get(field.getName()) != null) {
                JSONObject jsonObject = (JSONObject) json.get(field.getName());
                Class<?> clazz = field.getType();
                Object tempObject = fromJson0(jsonObject, clazz);
                field.set(instance, tempObject);
            }
        }

    private static Object fromJson0(JSONObject jsonObject,Class<?> clazz){
        Field[] fields = clazz.getDeclaredFields();
        Object o1 = createInstance(clazz);
        Arrays.stream(fields).forEach(
                field -> {
                    try {
                        field.setAccessible(true);
                        fieldSet(field, jsonObject, o1);
                    } catch (IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
        );
        return o1;
    }

    private static <T> T createInstance(Class<T> classType) {
        try {
            return classType.getConstructor().newInstance();
        }catch (InvocationTargetException | IllegalAccessException |NoSuchMethodException | InstantiationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
