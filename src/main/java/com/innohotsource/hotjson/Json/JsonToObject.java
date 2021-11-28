/**
 * @filename : JsonToObject.java
 * @description : JsonToObject impl
 */
package com.innohotsource.hotjson.Json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author Kim minsu
 * @version 1.0
 */
public class JsonToObject {
    /**
     * Fill in the jsonObject value to the instance.
     * @param json JsonObject you want to put as input
     * @param instance Instance that wants to receive input
     * @return instance full of json data
     */
    public static Object fromJson(JSONObject json,Object instance){
        fromJsonHide(json, instance);
        return instance;
    }

    /**
     * Constructor not available
     */
    private JsonToObject(){}

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
        if (field.getType() == Boolean.class){
            field.set(instance, value);
            return ;
        }
         if (field.getType() == List.class) {
            JSONArray jsonArray = (JSONArray) json.get(field.getName());
            Type[] parameterizedType = ((ParameterizedType) field.getGenericType())
                                            .getActualTypeArguments();

            Class clazz = (Class) parameterizedType[0];
            Object o = createInstance(clazz);
            List<Object> listTemp = new ArrayList<>();
             for (int i = 0; i < jsonArray.size(); i++) {
                 Object returnObject = fromJson0((JSONObject) jsonArray.get(i), clazz);
                 listTemp.add(returnObject);
             }
            field.set(instance, listTemp);
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
