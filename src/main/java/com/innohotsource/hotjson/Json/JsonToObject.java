package com.innohotsource.hotjson.Json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;


public class JsonToObject {

    public static Object fromJson(JSONObject json,Object instance){
        fromJsonHide(json, instance);
        return instance;
    }

    private static void fromJsonHide(JSONObject json, Object instance) {
        Field[] fields = instance.getClass().getDeclaredFields();
        Arrays.stream(fields).forEach(
                field -> {
                    field.setAccessible(true);
                    try {
                        fieldSet(field, json, instance);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
        );
    }


    private static void fieldSet(Field field, JSONObject json, Object instance) throws IllegalAccessException{
        Object value = json.get(field.getName());
        if (field.getType() == Integer.class) {
            field.set(instance, value);
            return ;
        }
        if (field.getType() == String.class) {
            field.set(instance, value);
            return ;
        }
        if (field.getType() == Long.class) {
            field.set(instance, value);
            return ;
        }
        if (field.getType() == Float.class) {
            field.set(instance, value);
            return ;
        }
        if (field.getType() == Number.class) {
            field.set(instance, value);
            return ;
        }
         if (field.getType() == List.class) {
            JSONArray jsonArray = (JSONArray) json.get(field.getName());
            field.set(instance,jsonArray);
            return ;
            }
         JSONObject jsonObject = (JSONObject) json.get(field.getName());
         Class<?> clazz = field.getType();
         Object tempObject = fromJson0(jsonObject, clazz);
         field.set(instance, tempObject);
        }

    private static Object fromJson0(JSONObject jsonObject,Class<?> clazz){
        Field[] fields = clazz.getDeclaredFields();
        Object o1 = createInstance(clazz);
        Arrays.stream(fields).forEach(
                field -> {
                    try {
                        field.setAccessible(true);
                        fieldSet(field, jsonObject, o1);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
        );
        return o1;
    }

    private static <T> T createInstance(Class<T> classType) {
        try {
            return classType.getConstructor().newInstance();
        }catch (IllegalAccessException | NoSuchMethodException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}
