package com.innohotsource.hotjson.Json;

import com.sun.jdi.ClassType;
import org.json.simple.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonToObject {

    public static Object fromJson(JSONObject json, Object instance){
        Class clazz = instance.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Arrays.stream(fields).forEach(
                field -> {
                    field.setAccessible(true);
                    try {
                        System.out.println("field.getType() = " + field.getType());
                        fieldSet(field, json, instance);
                    } catch (IllegalAccessException | NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                }
        );
        return instance;
    }

    private static void fieldSet(Field field, JSONObject json, Object instance) throws IllegalAccessException, NoSuchFieldException {

        if (field.getType() == String.class){
            field.set(instance,json.get(field.getName()));
        }
        if (field.getType() == Long.class){
            field.set(instance, json.get(field.getName()));
        }
        if (field.getType()  ==  Integer.class){
            field.set(instance, json.get(field.getName()));
        }
        if (field.getType() ==  Float.class){
            field.set(instance, json.get(field.getName()));
        }
        if (field.getType() ==  Number.class){
            field.set(instance, json.get(field.getName()));
        }

        if (json.get(field.getName()) != null && json.get(field.getName()) instanceof Object){
            fromJson(json, instance.getClass().getDeclaredField(field.getName()));
            System.out.println("instance.getClass().getField(field.getName()) = " + instance.getClass().getField(field.getName()));
            fromJson(, instance);
            System.out.println("json.get(field.getName()) = " + json.get(field.getName()));
        }
        if (field.getType() == Map.class){
            fromJson(json, json.get(field.getName()));
            System.out.println("json.get(field.getName()) = " + json.get(field.getName()));
        }
    }
    private static <T> T createInstance(Class<T> classType) {
        try {
            return classType.getConstructor().newInstance();
        }catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException | InstantiationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
